package com.example.gioco

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text


class ScacchieraView: View {

    constructor(context:Context): super(context, null )
    constructor(context:Context, attrs: AttributeSet?) : super(context,attrs, 0)


    var schermo = Rect()
    val Nero = Paint()
    val Bianco = Paint()

    var div:Int =2        //ho lasciato divisions fuori per renderla accessibile dalla main activity
    var dxt=0
    var dyt=0


   // var valori = arrayOfNulls<Int>(div*div)

    override fun onDraw(canvas: Canvas?) {  //il canvas è la nostra tela quindi oltre non possiamo andare,attenzione
        super.onDraw(canvas)

        canvas?.getClipBounds(schermo)        // mi prende la dimensione dello schermo con ClipBounds

        var dx = (schermo.right-schermo.left)/div
        var dy = (schermo.bottom-schermo.top)/div
        dxt=dx
        dyt=dy

        Nero.color= Color.BLACK     //Posso settare il colore del pennello solo in onDraw
        Bianco.color = Color.WHITE



        for (i in 0..div){
            for (j in 0..div){
                var left = schermo.left+j*dx        //calcolo iterativamente la posizione nei for
                var right = left + dx
                var top = schermo.top+i*dy
                var bottom = top + dy

                var casella = Rect(left,top,right,bottom)       //crea la casella nella posizione corretta

                if((i+j)%2==0){
                    canvas?.drawRect(casella, Nero)        //dice dipingi sulla casella con il pennello.Mettere il ? per sicurezza.
                   // valori.set(j + (i * div),1)
                    }

                else{
                    canvas?.drawRect(casella, Bianco)
                    //valori.set(j + (i * div),0)
                }



            }

        }//fine for innestato
/*
        for (element in valori) {
            println(element)
        }
*/

    }

/*
   fun AggiornaCasella(x:Int , y:Int) {
       var i=x/dx
       var j=y/dy
      // canvas?.drawRect(casella, Bianco)
   }
*/





}



