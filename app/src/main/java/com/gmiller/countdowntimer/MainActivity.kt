package com.gmiller.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.gmiller.countdowntimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btStart.setOnClickListener {
                startCountDownTimer(30000)
            }
        }
    }
    private fun startCountDownTimer(timeMillis: Long){
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 10){
            override fun onTick(timeM: Long) {
                binding.tvTimer.text = timeM.toString()
            }

            override fun onFinish() {
                binding.tvTimer.text = "Время вышло!"
            }

        }.start()
    }
}