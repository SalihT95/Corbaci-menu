package com.salihturkoglu.vizeuygulama

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.salihturkoglu.vizeuygulama.databinding.ActivitySiparisEkraniBinding

class SiparisEkrani : AppCompatActivity() {

    private lateinit var binding: ActivitySiparisEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySiparisEkraniBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var fulistek=""
        val tuz = intent.getStringExtra("tuz")
        val aci = intent.getStringExtra("aci")
        val istekler1 = intent.getStringExtra("istekler1")
        val istekler2 = intent.getStringExtra("istekler2")
        val istekler3 = intent.getStringExtra("istekler3")
        val istekler4 = intent.getStringExtra("istekler4")
        val istekler5 = intent.getStringExtra("istekler5")
        val istekler6 = intent.getStringExtra("istekler6")
        val istekler7 = intent.getStringExtra("istekler7")
        val istekler8 = intent.getStringExtra("istekler8")
        val istekler9 = intent.getStringExtra("istekler9")
        val istekler10 = intent.getStringExtra("istekler10")
        val istekler11 = intent.getStringExtra("istekler11")
        val istekler12 = intent.getStringExtra("istekler12")
        val corba = intent.getStringExtra("corba")
        val istektext = intent.getStringExtra("istektext")
        if (istektext==""){
            binding.textViewExtra.visibility=View.INVISIBLE
        }
        if(istekler1!=""){
            fulistek=fulistek.toString()+"Kıtır, "
        }
        if (istekler2!=""){
            fulistek=fulistek.toString()+"Terbiye, "
        }
        if (istekler3!=""){
            fulistek=fulistek.toString()+"Toz Biber, "
        }
        if (istekler4!=""){
            fulistek=fulistek.toString()+"Yağ, "
        }
        if (istekler5!=""){
            fulistek=fulistek.toString()+"Sirke, "
        }
        if (istekler6!=""){
            fulistek=fulistek.toString()+"Nane, "
        }
        if (istekler7!=""){
            fulistek=fulistek.toString()+"Krema, "
        }
        if (istekler8!=""){
            fulistek=fulistek.toString()+"Dil, "
        }
        if (istekler9!=""){
            fulistek=fulistek.toString()+"Beyin, "
        }
        if (istekler10!=""){
            fulistek=fulistek.toString()+"Kaşar, "
        }
        if (istekler11!=""){
            fulistek=fulistek.toString()+"Sarımsak, "
        }
        if (istekler12!=""){
            fulistek=fulistek.toString()+"Limon"
        }
        if(fulistek==""){
            binding.textViewicerik.visibility=View.INVISIBLE
        }

        binding.textViewExtra.text = "Extra İstek: $istektext"
        binding.text1.text = "Bir $corba Çorbası Çeeek,$tuz ve $aci olsun"

        binding.textViewicerik.text ="İçinde\n\n"+fulistek+"\n\nOlsun"

        object : CountDownTimer(310000000, 500) {
            override fun onTick(millisUntilFinished: Long) {
                var b = millisUntilFinished.toInt()
                b = b / 100
                if (b % 2 == 0) {
                    //binding.textViewYeniSiparis.visibility=View.VISIBLE
                    binding.textViewYeniSiparis.setTextColor(Color.WHITE)

                } else {
                    binding.textViewYeniSiparis.setTextColor(Color.BLACK)

                    //binding.textViewYeniSiparis.visibility=View.INVISIBLE
                }
            }

            override fun onFinish() {
                binding.textViewYeniSiparis.visibility = View.VISIBLE
            }
        }.start()


    }

    fun uygFinish(view: View) {
        val builder = AlertDialog.Builder(this@SiparisEkrani)
        with(builder) {

            setIcon(R.drawable.carpi)
            setTitle("Çıkış")
            setMessage("Çıkmak İstediğinize Emin Misiniz?")
            setPositiveButton("Evet", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()

            })
            setNegativeButton("Hayır", DialogInterface.OnClickListener { dialogInterface, i ->

            })


        }
        val alertDialog = builder.create()
        alertDialog.show()
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(
            resources.getColor(
                R.color.teal_200
            )
        )
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(
            resources.getColor(
                R.color.teal_200
            )
        )


    }

    fun yeniSiparis(view: View) {
        val intent = Intent(this@SiparisEkrani, MenuActivity::class.java)
        startActivity(intent)
        finish()

    }
}