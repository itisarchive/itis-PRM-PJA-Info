package pl.edu.pja.kdudek.pjainfo

import android.content.Context

interface Feature {
    val isAvailable: Boolean get() = false
    fun start(context: Context)
}