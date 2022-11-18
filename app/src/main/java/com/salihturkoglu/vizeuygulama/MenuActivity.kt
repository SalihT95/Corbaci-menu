package com.salihturkoglu.vizeuygulama

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.salihturkoglu.vizeuygulama.databinding.ActivityMenuBinding
import com.salihturkoglu.vizeuygulama.databinding.ActivityOzelToastMessageBinding


class MenuActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMenuBinding
    private var corba:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
        binding.radioGroup.visibility=View.INVISIBLE
        binding.buttonDevam.visibility=View.INVISIBLE

        binding.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.radioGroup.visibility=View.VISIBLE
                binding.buttonDevam.visibility=View.VISIBLE
            }else{
                binding.radioGroup.visibility=View.INVISIBLE
                binding.buttonDevam.visibility=View.INVISIBLE
            }
        }
        //val secilenCorba :Int= binding.radioGroup.checkedRadioButtonId
        //corba=(findViewById<RadioButton>(secilenCorba)).text.toString()
        //println(secilenCorba)

        binding.ezogelin.setOnCheckedChangeListener { compoundButton, b ->
            if (b){ corba="${binding.ezogelin.text}"}}
        binding.dugun.setOnCheckedChangeListener { compoundButton, b ->
            if (b) { corba="${binding.dugun.text}" } }
        binding.mercimek.setOnCheckedChangeListener { compoundButton, b ->
            if (b){corba="${binding.mercimek.text}"}}
        binding.brokoli.setOnCheckedChangeListener { compoundButton, b ->
            if (b){corba="${binding.brokoli.text}"}}
        binding.kellepaca.setOnCheckedChangeListener { compoundButton, b ->
            if (b){corba="${binding.kellepaca.text}"}}
        binding.yayla.setOnCheckedChangeListener { compoundButton, b ->
            if (b){corba="${binding.yayla.text}"}}
        binding.sehriye.setOnCheckedChangeListener { compoundButton, b ->
            if (b){corba="${binding.sehriye.text}"}}
        binding.domates.setOnCheckedChangeListener { compoundButton, b ->
            if (b){ corba="${binding.domates.text}" }}
        binding.tarhana.setOnCheckedChangeListener { compoundButton, b ->
            if (b){ corba="${binding.tarhana.text}" }}
        binding.mantar.setOnCheckedChangeListener { compoundButton, b ->
            if (b){ corba="${binding.mantar.text}" }}
        binding.iskembe.setOnCheckedChangeListener { compoundButton, b ->
            if (b){ corba="${binding.iskembe.text}" }}
        binding.tavuk.setOnCheckedChangeListener { button, b ->
            if (b){ corba="${binding.tavuk.text}" }}

    }


    fun clickedDevam(view: View) {

        if(corba==""){
            //Alert
            val builder = AlertDialog.Builder(this)
            with(builder) {

                setIcon(R.drawable.stlogo)
                setTitle("Uyarı!")
                setMessage("Lütfen Seçiminizi yapınız")
                setNeutralButton("Tekrar Dene", null)
            }
            val alertDialog = builder.create()
            alertDialog.show()
            alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(resources.getColor(R.color.teal_200))

        }else{
            var tasarim = layoutInflater.inflate(R.layout.activity_ozel_toast_message,null)
            var toastview= tasarim.findViewById<TextView>(R.id.textViewToast)
            toastview.setText(corba+" Çorbası Güzel Seçim Lütfen Bekleyiniz...")
            var toastozel = Toast(applicationContext)
            val intent = Intent(this@MenuActivity,ActivityOzelToastMessageBinding::class.java)
            intent.putExtra("corba",corba)
            toastozel.view=tasarim
            toastozel.setGravity(Gravity.BOTTOM,0,0)
            toastozel.duration = Toast.LENGTH_LONG
            toastozel.show()

            object : CountDownTimer(3100, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    val intent=Intent(this@MenuActivity,CorbaMalzeme::class.java)
                    intent.putExtra("corba",corba)
                    startActivity(intent)
                    finish()
                }
            }.start()
        }
    }
}