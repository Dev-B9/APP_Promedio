package com.example.promstudents

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal
import java.text.DecimalFormat
import java.math.RoundingMode


import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    var promedioRedondeado= 0.0
    var personName: EditText? = null
    var materiaStudent: EditText? = null
    var sNota1: EditText? = null
    var sNota2: EditText? = null
    var sNota3: EditText? = null
    var result: TextView? = null
    var name= ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personName = findViewById(R.id.PersonName)
        materiaStudent = findViewById(R.id.MateriaStudent)
        sNota1 = findViewById(R.id.number1)
        sNota2 = findViewById(R.id.number2)
        sNota3 = findViewById(R.id.number3)
        result = findViewById(R.id.result)


        var btnCalcular: Button = findViewById(R.id.buttonResult)
            btnCalcular.setOnClickListener{onClick(1)}
        var btnShowScreen: Button = findViewById(R.id.buttonOtherScreen)
            btnShowScreen.setOnClickListener{onClick(2)}



    }

    private fun onClick(boton: Int) {
        var resultados = ""

        when (boton){
            1 ->{

                name =  personName!!.text.toString()
                val materia:String = materiaStudent!!.text.toString()
                val nota1:Double = sNota1!!.text.toString().toDouble()
                val nota2:Double = sNota2!!.text.toString().toDouble()
                val nota3:Double = sNota3!!.text.toString().toDouble()

                val formato = DecimalFormat("#.##")
                 var promedio: Double = (nota1 + nota2 + nota3)/3
                 promedioRedondeado = BigDecimal(promedio.toString()).setScale(2,RoundingMode.HALF_UP).toDouble()

                if (nota1 > 5 || nota1 < 1 || nota2 > 5 || nota2 < 1 || nota3 > 5 || nota3 < 1 ){

                    resultados = "El rango de la nota es invalido entre 0 y 5 "
                    result!!.setTextColor(Color.RED)

                }else if (promedio >= 3.5){
                    resultados ="El estudiante: ${name}\n paso la materia: ${materia} \n con el promedio: ${promedioRedondeado} \n y aprobo la materia"
                    result!!.setTextColor(Color.GREEN)

                }else{
                    resultados= "El estudiante: ${name} n no paso la materia: ${materia} \n con el promedio: ${promedioRedondeado} \n no aprobo la materia"
                    result!!.setTextColor(Color.RED)

                }
                result?.text= resultados


            }

            2 ->{
                val intent = Intent(this,MessageProm::class.java)
                val miBundle:Bundle=Bundle()
                miBundle.putDouble("Resultados", promedioRedondeado)
                miBundle.putString("name", name)
                intent.putExtras(miBundle)
                startActivity(intent)
            }
        }
    }
}