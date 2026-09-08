package com.example.menu

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnArea = findViewById<Button>(R.id.btnArea)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        val btnFormulario = findViewById<Button>(R.id.btnFormulario)

        btnArea.setOnClickListener {
            val intent = Intent(this, AreaActivity::class.java)
            startActivity(intent)
        }

        btnIMC.setOnClickListener {
            val intent = Intent(this, IMCalc::class.java)
            startActivity(intent)
        }

        btnFormulario.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }
    }
}