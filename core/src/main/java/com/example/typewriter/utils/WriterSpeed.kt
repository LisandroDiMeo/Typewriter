package com.example.typewriter.utils

enum class WriterSpeed {SLOW, NORMAL, FAST}

fun determineDuration(content: String, writerSpeed: WriterSpeed = WriterSpeed.SLOW) : Long{
    return content.length * when(writerSpeed){
        WriterSpeed.SLOW -> 200L
        WriterSpeed.NORMAL -> 150L
        WriterSpeed.FAST -> 100L
    }
}