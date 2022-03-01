package com.github.typewriter

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.animation.doOnEnd
import com.example.typewriter.R
import com.github.typewriter.utils.WriterSpeed
import com.github.typewriter.utils.determineDuration

class Typewriter @JvmOverloads
constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr : Int = 0) : AppCompatTextView(context, attributeSet, defStyleAttr){
    private var animator: ValueAnimator
    var animationInterpolator : Interpolator = LinearInterpolator()

    private var writerSpeed: WriterSpeed
    private var textViewContent: String = text.toString()

    init {
        this.text = EMPTY_STRING
        val typedArray = context.obtainStyledAttributes(attributeSet,
            R.styleable.Typewriter, defStyleAttr, 0)
        writerSpeed  = WriterSpeed.values()[typedArray.getInt(R.styleable.Typewriter_writerSpeed, 0)]
        animator = ValueAnimator.ofInt(0, textViewContent.length - 1).apply {
            var index = -1
            duration = determineDuration(textViewContent, writerSpeed)
            addUpdateListener {
                val currentCharIndex = it.animatedValue as Int
                if(index != currentCharIndex){
                    val currentChar = textViewContent[currentCharIndex]
                    this@Typewriter.text = "${this@Typewriter.text}$currentChar"
                }
                index = currentCharIndex
            }
        }
        typedArray.recycle()
    }


    private fun reverseAnimation(){
        animator = ValueAnimator.ofInt(textViewContent.length - 1, 0).apply {
            var index = -1
            duration = determineDuration(textViewContent, writerSpeed)
            addUpdateListener {
                val currentCharIndex = it.animatedValue as Int
                if(index != currentCharIndex){
                    val currentChar = textViewContent[currentCharIndex]
                    this@Typewriter.text = this@Typewriter.text.subSequence(0, currentCharIndex)
                }
                index = currentCharIndex
            }
        }
        animator.startDelay = 1000L // Este delay sirve para que el reverso no arranque instantaneamente termina de escribir, si no, nunca llegamos a ver el ultimo caracter.
        animator.start()
    }

    fun startTypewriter(){
        animator.apply {
            interpolator = animationInterpolator
        }.start()
        animator.doOnEnd {
            reverseAnimation()
        }
    }

    companion object {
        private const val EMPTY_STRING = ""
    }
}