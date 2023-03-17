package com.example.promstudents

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MessageProm : AppCompatActivity() {
    var prom=0.0
    var name=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_prom)

            var miBundle:Bundle? = this.intent.extras
            val result = findViewById<TextView>(R.id.result)

            if (miBundle != null) {
                prom = miBundle.getDouble("Resultados")
                name= miBundle.getString("name").toString()
            }

        if(prom >=3.5){
            result!!.text = "Felicidades ${name} aprobo la materia en ${prom.toString()}"
            result!!.setTextColor(Color.GREEN)
        }else{
            result!!.text = "Desgraciadamente ${name} reprobo la materia en ${prom.toString()}"
            result!!.setTextColor(Color.RED)
        }

            val  btnBack: Button = findViewById(R.id.btnBack)
            btnBack.setOnClickListener{onClick()}
        }

        private  fun onClick(){
            finish()

    }


}