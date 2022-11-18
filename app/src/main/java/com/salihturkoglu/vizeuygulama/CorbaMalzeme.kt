package com.salihturkoglu.vizeuygulama

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.salihturkoglu.vizeuygulama.databinding.ActivityCorbaMalzemeBinding

class CorbaMalzeme : AppCompatActivity() {
    private lateinit var binding: ActivityCorbaMalzemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCorbaMalzemeBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        var tuz="tuzsuz"
        var aci="acısız"
        var kitir=""
        var yag=""
        var kasar=""
        var nane=""
        var limon=""
        var sarimsak=""
        var sirke=""
        var terbiye=""
        var tozbiber=""
        var dil=""
        var beyin=""
        var krema=""


        binding.switchNane.visibility=View.INVISIBLE
        binding.switchYag.visibility=View.INVISIBLE
        binding.switchKasar.visibility=View.INVISIBLE
        binding.switchKitir.visibility=View.INVISIBLE
        binding.switchLimon.visibility=View.INVISIBLE
        binding.switchSarimsak.visibility=View.INVISIBLE
        binding.switchSirke.visibility=View.INVISIBLE
        binding.switchTerbiye.visibility=View.INVISIBLE
        binding.switchTozBiber.visibility=View.INVISIBLE
        binding.switchDil.visibility=View.INVISIBLE
        binding.switchBeyin.visibility=View.INVISIBLE
        binding.switchKrema.visibility=View.INVISIBLE
        val corba =intent.getStringExtra("corba")
        binding.textViewCorbaAdi.setText("$corba Çorbası")
        if (corba=="Ezogelin"){
            binding.switchNane.visibility=View.VISIBLE
            binding.switchYag.visibility=View.VISIBLE
            binding.switchTozBiber.visibility=View.VISIBLE
            binding.switchKitir.visibility=View.VISIBLE
            binding.switchLimon.visibility=View.VISIBLE

        }else if (corba=="Düğün"){
            binding.switchNane.visibility=View.VISIBLE
            binding.switchYag.visibility=View.VISIBLE
            binding.switchTozBiber.visibility=View.VISIBLE
            binding.switchKitir.visibility=View.VISIBLE
            binding.switchLimon.visibility=View.VISIBLE
        }else if (corba=="Mercimek"){
            binding.switchNane.visibility=View.VISIBLE
            binding.switchYag.visibility=View.VISIBLE
            binding.switchTozBiber.visibility=View.VISIBLE
            binding.switchKitir.visibility=View.VISIBLE
            binding.switchLimon.visibility=View.VISIBLE
        }else if (corba=="Brokoli"){
            binding.switchKrema.visibility=View.VISIBLE
        }else if (corba=="Kelle-Paça"){
            binding.switchSarimsak.visibility=View.VISIBLE
            binding.switchDil.visibility=View.VISIBLE
            binding.switchBeyin.visibility=View.VISIBLE
            binding.switchSirke.visibility=View.VISIBLE
            binding.switchYag.visibility=View.VISIBLE
            binding.switchLimon.visibility=View.VISIBLE
        }else if (corba=="Yayla"){
            binding.switchNane.visibility=View.VISIBLE
            binding.switchYag.visibility=View.VISIBLE
            binding.switchTozBiber.visibility=View.VISIBLE
            binding.switchKitir.visibility=View.VISIBLE
        }else if (corba=="Şehriye"){
            binding.switchNane.visibility=View.VISIBLE
            binding.switchYag.visibility=View.VISIBLE
            binding.switchTozBiber.visibility=View.VISIBLE
            binding.switchLimon.visibility=View.VISIBLE

        }else if (corba=="Domates"){
            binding.switchNane.visibility=View.VISIBLE
            binding.switchYag.visibility=View.VISIBLE
            binding.switchTozBiber.visibility=View.VISIBLE
            binding.switchKitir.visibility=View.VISIBLE
            binding.switchLimon.visibility=View.VISIBLE
            binding.switchKasar.visibility=View.VISIBLE
            binding.switchTerbiye.visibility=View.VISIBLE
        }else if (corba=="Tarhana"){
            binding.switchYag.visibility=View.VISIBLE
            binding.switchTozBiber.visibility=View.VISIBLE
        }else if (corba=="Mantar"){
            binding.switchKrema.visibility=View.VISIBLE
        }else if (corba=="İşkembe"){
            binding.switchSarimsak.visibility=View.VISIBLE
            binding.switchSirke.visibility=View.VISIBLE
            binding.switchYag.visibility=View.VISIBLE
            binding.switchLimon.visibility=View.VISIBLE
            binding.switchTozBiber.visibility=View.VISIBLE

        }else if (corba=="Tavuk"){
            binding.switchYag.visibility=View.VISIBLE
            binding.switchLimon.visibility=View.VISIBLE
            binding.switchKrema.visibility=View.VISIBLE
        }
        binding.seekBarTuz.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, oran: Int, p2: Boolean) {
                if(oran==2){
                    val builder = AlertDialog.Builder(this@CorbaMalzeme)
                    with(builder) {
                        setIcon(R.drawable.tuz)
                        setCancelable(false)
                        setTitle("Uyarı!")
                        setMessage("Bu Kadar tuz İstediğinize Emin Misiniz?")
                        setPositiveButton("Evet",DialogInterface.OnClickListener { dialogInterface, i ->
                            Toast.makeText(getApplicationContext(), "Bol Tuzlu Çorba", Toast.LENGTH_LONG).show()
                            tuz="bol tuzlu"
                        })
                        setNegativeButton("Hayır",DialogInterface.OnClickListener { dialogInterface, i ->
                            tuz="orta tuzlu"
                            binding.seekBarTuz.setProgress(1)
                        })


                    }
                    val alertDialog = builder.create()
                    alertDialog.show()
                    alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(
                        R.color.teal_200
                    ))
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(
                        R.color.teal_200
                    ))

                }else{
                    if (oran==1){
                        tuz="orta tuzlu"
                    }else{
                        tuz="tuzsuz"
                    }

                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        binding.seekBarAci.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, oran: Int, p2: Boolean) {
                if(oran==2){
                    val builder = AlertDialog.Builder(this@CorbaMalzeme)
                    with(builder) {
                        setCancelable(false)
                        setIcon(R.drawable.aci)
                        setTitle("Uyarı!")
                        setMessage("Bu Kadar Acı İstediğinize Emin Misiniz?")
                        setPositiveButton("Evet",DialogInterface.OnClickListener { dialogInterface, i ->
                            Toast.makeText(this@CorbaMalzeme, "Bol Acılı Çorba", Toast.LENGTH_LONG).show()
                            aci="bol acılı"
                        })
                        setNegativeButton("Hayır",DialogInterface.OnClickListener { dialogInterface, i ->
                            aci="orta acılı"
                            binding.seekBarAci.setProgress(1)
                        })


                    }
                    val alertDialog = builder.create()
                    alertDialog.show()
                    alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(
                        R.color.teal_200
                    ))
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(
                        R.color.teal_200
                    ))
                }else{
                    if (oran==1){
                        aci="orta acılı"
                    }else{
                        aci="acısız"
                    }

                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })


        binding.siparisButton.setOnClickListener {
            // alert
            val builder = AlertDialog.Builder(this)
            with(builder) {
                setIcon(R.drawable.stlogo)
                setTitle("Siparişiniz Durumu")
                setMessage("Siparişiniz Hazırlanacak. Devam Etmek İstiyor Musunuz?")
                setCancelable(true)
                setNeutralButton("Tekrar Kontrol Etmek İstiyorum", null)
                setPositiveButton("Evet",DialogInterface.OnClickListener { dialogInterface, i ->
                    val intent= Intent(this@CorbaMalzeme,SiparisEkrani::class.java)
                    intent.putExtra("corba",corba)
                    intent.putExtra("tuz",tuz)
                    intent.putExtra("aci",aci)
                    intent.putExtra("istektext",binding.istekText.text.toString())
                    intent.putExtra("istekler1",kitir)
                    intent.putExtra("istekler2",terbiye)
                    intent.putExtra("istekler3",tozbiber)
                    intent.putExtra("istekler4",yag)
                    intent.putExtra("istekler5",sirke)
                    intent.putExtra("istekler6",nane)
                    intent.putExtra("istekler7",krema)
                    intent.putExtra("istekler8",dil)
                    intent.putExtra("istekler9",beyin)
                    intent.putExtra("istekler10",kasar)
                    intent.putExtra("istekler11",sarimsak)
                    intent.putExtra("istekler12",limon)

                    startActivity(intent)
                    finish()

                })


            }
            val alertDialog = builder.create()
            alertDialog.show()
            alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(resources.getColor(R.color.teal_200))
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.teal_200))
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).textSize=11f
            alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).textSize=11f
1
        }

        //switchler
        binding.switchKitir?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                kitir="Kıtır"
            } else {
                kitir=""
            }
        }
        binding.switchSirke?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sirke="Sirke"
            } else {
                sirke=""
            }
        }
        binding.switchSarimsak?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sarimsak="Sarımsak"
            } else {
                sarimsak=""
            }
        }
        binding.switchLimon?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                limon="Limon"
            } else {
                limon=""
            }
        }
        binding.switchYag?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                yag="Yağ"
            } else {
                yag=""
            }
        }
        binding.switchTozBiber?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tozbiber="Toz Biber"
            } else {
                tozbiber=""
            }
        }
        binding.switchTerbiye?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                terbiye="Terbiye"
            } else {
                terbiye=""
            }
        }
        binding.switchKasar?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                kasar="Kasar"
            } else {
                kasar=""
            }
        }
        binding.switchKrema?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                krema="Krema"
            } else {
                krema=""
            }
        }
        binding.switchDil?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                dil="Dil"
            } else {
                dil=""
            }
        }
        binding.switchBeyin?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                beyin="Beyin"
            } else {
                beyin=""
            }
        }
        binding.switchNane?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                nane="Nane"
            } else {
                nane=""
            }
        }


    }
}