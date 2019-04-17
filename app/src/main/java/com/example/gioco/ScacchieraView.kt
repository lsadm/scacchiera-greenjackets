package com.example.gioco

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import java.lang.Math.floor


class ScacchieraView: View {

    constructor(context:Context): super(context, null )
    constructor(context:Context, attrs: AttributeSet?) : super(context,attrs, 0)


    var schermo = Rect()
    val Nero = Paint()
    val Bianco = Paint()
    var div:Int =2        //ho lasciato divisions fuori per renderla accessibile dalla main activity
    var x=1
    var y=1
    var mat=Matrice<Boolean>(div,div)
    var dx=2
    var dy=2




    override fun onDraw(canvas: Canvas?) {  //il canvas è la nostra tela quindi oltre non possiamo andare,attenzione
        super.onDraw(canvas)

        canvas?.getClipBounds(schermo)        // mi prende la dimensione dello schermo con ClipBounds

        Nero.color= Color.BLACK     //Posso settare il colore del pennello solo in onDraw
        Bianco.color = Color.WHITE

        dx = (schermo.right-schermo.left)/div
        dy = (schermo.bottom-schermo.top)/div

        inizializzaMat(canvas)

    }


    fun inizializzaMat(canvas: Canvas?){

        for (i in 0..div-1){
            for (j in 0..div-1){
                var left = schermo.left+j*dx        //calcolo iterativamente la posizione nei for
                var right = left + dx
                var top = schermo.top+i*dy
                var bottom = top + dy

                var casella = Rect(left,top,right,bottom)       //crea la casella nella posizione corretta

                if((i+j)%2==0){
                    canvas?.drawRect(casella, Nero)        //dice dipingi sulla casella con il pennello.Mettere il ? per sicurezza.
                    mat[i,j]=true   // nero è associato a vero
                }
                else {
                    canvas?.drawRect(casella, Bianco)
                    mat[i,j]=false                          //bianco è associato a falso
                }
            }

        }// for di prima costruzione

    }




/*
  fun AggiornaCasella(){

      //x,y,matrix

      var i = x/dx
      var j = y/dy
      if(matrix[i,j]=true)
      matrix[i,j]=false //bianco
      else
          matrix[i,j]=true //nero



  }

*/

}



