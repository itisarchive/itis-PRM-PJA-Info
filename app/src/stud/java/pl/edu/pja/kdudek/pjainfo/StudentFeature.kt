package pl.edu.pja.kdudek.pjainfo

import android.content.*
import androidx.core.net.*

class StudentFeature : Feature {
    override val isAvailable: Boolean get() = true
    override fun start(context: Context) {
        /*context.startActivity(Intent(context, SecondScreen::class.java))*/
        context.startActivity(Intent(Intent.ACTION_VIEW, "https://www.pja.edu.pl/info".toUri()))
    }
}