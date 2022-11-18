package com.salihturkoglu.vizeuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.salihturkoglu.vizeuygulama.databinding.ActivitySifreliGirisBinding

class sifreliGiris : AppCompatActivity() {
    private lateinit var binding: ActivitySifreliGirisBinding
    var checkpointS:Boolean=false
    var checkpointA:Boolean=false
    var checkpointL:Boolean=false
    var checkpointI:Boolean=false
    var checkpointH:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySifreliGirisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.imageViewS.visibility=View.INVISIBLE
        binding.imageViewA.visibility=View.INVISIBLE
        binding.imageViewL.visibility=View.INVISIBLE
        binding.imageViewI.visibility=View.INVISIBLE
        binding.imageViewH.visibility=View.INVISIBLE
        binding.progressBar.visibility=View.INVISIBLE

    }
    fun clickedS(view : View){
        binding.imageViewS.visibility=View.VISIBLE
        checkpointS=true

    }
    fun clickedA(view : View){
        if(checkpointS){
            binding.imageViewA.visibility=View.VISIBLE
            checkpointA=true
        }

    }
    fun clickedL(view : View){
        if(checkpointS&&checkpointA){
            binding.imageViewL.visibility=View.VISIBLE
            checkpointL=true
        }
    }
    fun clickedI(view : View){
        if(checkpointS&&checkpointA&&checkpointL){
            binding.imageViewI.visibility=View.VISIBLE
            checkpointI=true
        }
    }
    fun clickedH(view : View){
        if(checkpointS&&checkpointA&&checkpointL&&checkpointI){
            binding.imageViewH.visibility=View.VISIBLE
            object : CountDownTimer(2000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    binding.progressBar.visibility=View.VISIBLE
                }

                override fun onFinish() {
                    val intent= Intent(this@sifreliGiris,MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }.start()



        }


    }
}