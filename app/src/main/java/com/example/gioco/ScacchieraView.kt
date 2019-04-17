package com.example.gioco

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
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

    var init: Int=1


    override fun onDraw(canvas: Canvas?) {  //il canvas è la nostra tela quindi oltre non possiamo andare,attenzione
        super.onDraw(canvas)


        canvas?.getClipBounds(schermo)        // mi prende la dimensione dello schermo con ClipBounds

        Nero.color= Color.BLACK     //Posso settare il colore del pennello solo in onDraw
        Bianco.color = Color.WHITE

        dx = (schermo.right-schermo.left)/div
        dy = (schermo.bottom-schermo.top)/div

        if (init==1){
            var updated_matrix=Matrice<Boolean>(div,div)//Devo lasciarlo per aggiornare la nuova matrice!
            mat=updated_matrix
            inizializzaMat()
            init=0}

        for (i in 0..div-1){
            for (j in 0..div-1){
                var left = schermo.left+j*dx        //calcolo iterativamente la posizione nei for
                var right = left + dx
                var top = schermo.top+i*dy
                var bottom = top + dy

                var casella = Rect(left,top,right,bottom)       //crea la casella nella posizione corretta

                if(mat[i,j]==true) {     //nero è vero
                    canvas?.drawRect(casella, Nero) }       //dice dipingi sulla casella con il pennello.Mettere il ? per sicurezza.
                else {
                    canvas?.drawRect(casella, Bianco)}

            }

        }// for di prima costruzione

    }



    fun inizializzaMat(){

        for (i in 0..div-1){
            for (j in 0..div-1) {
                if((i+j)%2==0)
                    mat[i,j]=true   // nero è associato a vero
                else
                    mat[i,j]=false
                }
            }
    }


  fun AggiornaCasella(){

      val j = x/dx  //colonna
      val i = y/dy   //riga
      var index=0


      for(index in 0..div-1){   //inverto la riga

          if(mat[index,j]==true)
              mat[index,j]=false
          else
              mat[index,j]=true

      }

        index=0

      for(index in 0..div-1){   //inverto la riga

          if(mat[i,index]==true)
              mat[i,index]=false
          else
              mat[i,index]=true

      }




  }



}



