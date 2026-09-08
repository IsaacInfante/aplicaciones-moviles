package com.example.menu

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val spinnerCarrera = findViewById<Spinner>(R.id.spinnerCarrera)
        val rgTurno = findViewById<RadioGroup>(R.id.rgTurno)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvResumen = findViewById<TextView>(R.id.tvResumen)
        val btnVolver = findViewById<Button>(R.id.btnVolverMenuFormulario)

        val carreras = arrayOf(
            "Selecciona una carrera",
            "Sistemas Embebidos",
            "Mecatrónica",
            "Industrial",
            "Diseño Industrial"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            carreras
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinnerCarrera.adapter = adapter

        btnMostrar.setOnClickListener {

            val nombre = etNombre.text.toString()
            val carrera = spinnerCarrera.selectedItem.toString()
            val turnoSeleccionado = rgTurno.checkedRadioButtonId

            if (nombre.isEmpty()) {
                etNombre.error = "Ingresa tu nombre"
                return@setOnClickListener
            }

            if (spinnerCarrera.selectedItemPosition == 0) {
                tvResumen.text = "Selecciona una carrera"
                return@setOnClickListener
            }

            if (turnoSeleccionado == -1) {
                tvResumen.text = "Selecciona un turno"
                return@setOnClickListener
            }

            val radioButton =
                findViewById<RadioButton>(turnoSeleccionado)

            val turno = radioButton.text.toString()

            tvResumen.text =
                "Nombre: $nombre\n" +
                        "Carrera: $carrera\n" +
                        "Turno: $turno"
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}