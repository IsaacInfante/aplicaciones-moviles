package com.example.menu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IMCalc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcalc)

        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnCalcular.setOnClickListener {

            val peso = etPeso.text.toString().toDoubleOrNull()
            val altura = etAltura.text.toString().toDoubleOrNull()

            if (peso != null && altura != null && altura > 0) {

                val imc = peso / (altura * altura)

                val clasificacion = when {
                    imc < 18.5 -> "Bajo peso"
                    imc < 25.0 -> "Peso normal"
                    imc < 30.0 -> "Sobrepeso"
                    else -> "Obesidad"
                }

                tvResultado.text =
                    "IMC: %.2f\n%s".format(imc, clasificacion)

            } else {
                tvResultado.text = "Ingresa valores válidos"
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}