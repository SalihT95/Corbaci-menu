package com.salihturkoglu.vizeuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.salihturkoglu.vizeuygulama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var fsize : Float
        fsize= 8F
        object : CountDownTimer(3500, 10) {
            override fun onTick(millisUntilFinished: Long) {
                if(millisUntilFinished >2900){
                    binding.textView.textSize=fsize
                    fsize+=2F
                }
            }
            override fun onFinish() {
                val intent=Intent(this@MainActivity,sifreliGiris::class.java)
                startActivity(intent)
                finish()
            }
        }.start()

    }
}