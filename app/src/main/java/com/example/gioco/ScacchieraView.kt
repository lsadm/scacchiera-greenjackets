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

class ScacchieraView: View {

    constructor(context:Context): super(context, null )
    constructor(context:Context, attrs: AttributeSet?) : super(context,attrs, 0)




    override fun onDraw(canvas: Canvas?) {  //il canvas è la nostra tela quindi oltre non possiamo andare,attenzione
        super.onDraw(canvas)
         var casella=Rect(100,100,200,200)
         var paint = Paint()
         var schermo = Rect()
        canvas?.getClipBounds(schermo)        // mi prende la dimensione dello schermo con ClipBounds

        paint.color= Color.GREEN // è il pennello
        canvas?.drawRect(casella,paint) //dice dipingi sulla casella con il pennello.Mettere il ? per sicurezza.

    }



    override fun onTouchEvent(event: MotionEvent?): Boolean {

        return super.onTouchEvent(event)   //in event c'è il significato del tocco
        if(event?.action==MotionEvent.ACTION_UP) {     //MotionEvent ha molti metodi ! L'evento ha l'info action, a noi interessa l'action UP
            var x = event?.x          // Action Up legge quando il dito se ne va
            var y = event?.y
        }
    }

















            }


