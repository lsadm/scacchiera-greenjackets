package com.example.gioco

import android.graphics.Canvas
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var div: Int = 2            //valore iniizale delle divisioni quando si apre l'app

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mosse = findViewById<View>(R.id.mosse) as TextView

        val seekbar=findViewById<View>(R.id.SeekBar) as SeekBar     //da qui inizia la lettura dei valori della seekbar

        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { //cose da fare quando cambia il valore
                div=progress+2              //setto il minimo della seekbar a 2, visto che parte da 0
                div_count.text= div.toString()
                vScacchiera.div=div

            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}         //devo per forza fare l'ovveride, anche se non le specifico
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        val play = findViewById<View>(R.id.Gioca) as Button //eventi da eseguire quando premo "Gioca"
        play.setOnClickListener{
            Toast.makeText(this@MainActivity, "Stai giocando con "+div+" divisioni", Toast.LENGTH_SHORT).show()
            vScacchiera.invalidate()        //Serve per invalidare la view e forzare la chiamata del metodo onDraw di ScacchieraView
            mosse.text= 0.toString()
        }


        vScacchiera.setOnTouchListener(View.OnTouchListener { _, motionEvent ->
            when (motionEvent.action){

                MotionEvent.ACTION_UP -> {
                    var x = motionEvent.x.toInt()
                    var y = motionEvent.y.toInt()
                    Toast.makeText(this@MainActivity, "X: "+x+" Y: "+y, Toast.LENGTH_SHORT).show()

                }
            }
            return@OnTouchListener true
        })


    }


}
