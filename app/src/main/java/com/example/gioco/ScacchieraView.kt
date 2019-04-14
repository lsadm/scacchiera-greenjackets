package com.example.gioco

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener

class ScacchieraView: View {

    constructor(context:Context): super(context, null )
    constructor(context:Context, attrs: AttributeSet?) : super(context,attrs, 0)


    var schermo = Rect()
    val Nero = Paint()
    val Bianco = Paint()



    override fun onDraw(canvas: Canvas?) {  //il canvas è la nostra tela quindi oltre non possiamo andare,attenzione
        super.onDraw(canvas)

        canvas?.getClipBounds(schermo)        // mi prende la dimensione dello schermo con ClipBounds

        var div = SeekBar.OnSeekBarChangeListener(this)


        Nero.color= Color.BLACK     //Posso settare il colore del pennello solo in onDraw
        Bianco.color = Color.WHITE


        var dx = (schermo.right-schermo.left)/div
        var dy = (schermo.bottom-schermo.top)/div


        for (i in 0..div){
            for (j in 0..div){
                var left = schermo.left+j*dx        //calcolo iterativamente la posizione nei for
                var right = left + dx
                var top = schermo.top+i*dy
                var bottom = top + dy

                var casella = Rect(left,top,right,bottom)       //crea la casella nella posizione corretta

                if((i+j)%2==0)
                    canvas?.drawRect(casella, Nero)        //dice dipingi sulla casella con il pennello.Mettere il ? per sicurezza.
                else
                    canvas?.drawRect(casella, Bianco)
            }

        }




    }


/*
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        return super.onTouchEvent(event)   //in event c'è il significato del tocco
        if(event?.action==MotionEvent.ACTION_UP) {     //MotionEvent ha molti metodi ! L'evento ha l'info action, a noi interessa l'action UP
            var x = event?.x          // Action Up legge quando il dito se ne va
            var y = event?.y
        }
    }
*/




}


