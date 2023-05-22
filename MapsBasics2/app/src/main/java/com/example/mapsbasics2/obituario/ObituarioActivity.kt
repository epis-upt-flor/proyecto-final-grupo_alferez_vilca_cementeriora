package com.example.mapsbasics2.obituario

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mapsbasics2.databinding.ActivityObituarioBinding

class ObituarioActivity : AppCompatActivity() {

    lateinit var binding: ActivityObituarioBinding
    lateinit var amigosDBHelper: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObituarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        amigosDBHelper = miSQLiteHelper(this)

        binding.btGuardar.setOnClickListener {
            if (binding.etNombre.text.isNotBlank() && binding.etApellidos.text.isNotBlank() &&
                binding.etEmail.text.isNotBlank()) {
                amigosDBHelper.anyadirDato(binding.etNombre.text.toString(),binding.etApellidos.text.toString(),
                    binding.etEmail.text.toString())
                binding.etNombre.text.clear()
                binding.etApellidos.text.clear()
                binding.etEmail.text.clear()
                Toast.makeText(this, "Guardado",
                    Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "No se ha podido guardar",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.btConsultar.setOnClickListener {
            binding.tvConsulta.text = ""
            val db : SQLiteDatabase = amigosDBHelper.readableDatabase
            val cursor = db.rawQuery(
                "SELECT * FROM amigos",
                null)

            if (cursor.moveToFirst()) {
                do {
                    binding.tvConsulta.append(
                        cursor.getInt(0).toString() + ": ")
                    binding.tvConsulta.append(
                        cursor.getString(1).toString()+ ", ")
                    binding.tvConsulta.append(
                        cursor.getString(2).toString()+ ", ")
                    binding.tvConsulta.append(
                        cursor.getString(3).toString() + "\n")
                } while (cursor.moveToNext())
            }

        }

        binding.btBorrar.setOnClickListener {

            var cantidad = 0

            if (binding.etId.text.isNotBlank()) {
                cantidad = amigosDBHelper.borrarDato(
                    binding.etId.text.toString().toInt())
                binding.etId.text.clear()
            }
            else {
                Toast.makeText(this,
                    "Datos borrados: $cantidad",
                    Toast.LENGTH_LONG).show()
            }

        }

        binding.btModificar.setOnClickListener {
            if (binding.etNombre.text.isNotBlank() &&
                binding.etApellidos.text.isNotBlank() &&
                binding.etEmail.text.isNotBlank() &&
                binding.etId.text.isNotBlank()) {
                amigosDBHelper.modificarDato(
                    binding.etId.text.toString().toInt(),
                    binding.etNombre.text.toString(),
                    binding.etApellidos.text.toString(),
                    binding.etEmail.text.toString())
                binding.etNombre.text.clear()
                binding.etApellidos.text.clear()
                binding.etEmail.text.clear()
                binding.etId.text.clear()
                Toast.makeText(this, "Modificado",
                    Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this,
                    "Los campos no deben estar vacíos",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.btConsultarLV.setOnClickListener {
            val intentListView = Intent(this, ActivityLista::class.java)
            startActivity(intentListView)
        }


    }
}