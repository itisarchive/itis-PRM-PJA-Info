package pl.edu.pja.kdudek.pjainfo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pl.edu.pja.kdudek.pjainfo.databinding.ActivityMainBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val days = resources.getStringArray(R.array.days)
        val currentDay = LocalDate.now().dayOfWeek.ordinal
        for (i in days.indices) {
            val idx = (currentDay + i) % days.size
            val label = TextView(this).apply {
                text = days[idx]
            }
            binding.openingHours.addView(label)
        }

        val student = StudentFeature()
        if (student.isAvailable) {
            binding.button.setOnClickListener {
                student.start(this)
            }
        } else {
            binding.button.visibility = View.GONE
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}