package com.github.typewriter

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.*
import androidx.appcompat.widget.AppCompatTextView
import com.example.typewriter.R
import com.github.typewriter.utils.WriterSpeed
import com.github.typewriter.utils.determineDuration

class Typewriter @JvmOverloads
constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr : Int = 0) : AppCompatTextView(context, attributeSet, defStyleAttr){
    private var animator: ValueAnimator
    var animationInterpolator : Interpolator = LinearInterpolator()

    init {
        val textViewContent = this.text
        this.text = EMPTY_STRING
        val typedArray = context.obtainStyledAttributes(attributeSet,
            R.styleable.Typewriter, defStyleAttr, 0)
        val writerSpeed : WriterSpeed = WriterSpeed.values()[typedArray.getInt(R.styleable.Typewriter_writerSpeed, 0)]
        animator = ValueAnimator.ofInt(0, textViewContent.length - 1).apply {
            var index = -1
            duration = determineDuration(textViewContent.toString(), writerSpeed)
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

    fun startTypewriter(){
        animator.apply {
            interpolator = animationInterpolator
        }.start()
    }

    companion object {
        private const val EMPTY_STRING = ""
    }
}