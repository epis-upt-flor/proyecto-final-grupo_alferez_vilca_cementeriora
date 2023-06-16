package com.example.mapsbasics2.obituario

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mapsbasics2.databinding.ActivityObituarioBinding

class ObituarioActivity : AppCompatActivity() {

    lateinit var binding: ActivityObituarioBinding
    lateinit var obituarioDBHelper: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObituarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        obituarioDBHelper = miSQLiteHelper(this)

        binding.btGuardar.setOnClickListener {
            if (binding.etNombre.text.isNotBlank() && binding.etApellidos.text.isNotBlank() &&
                binding.etFecha.text.isNotBlank() && binding.etLugar.text.isNotBlank() && binding.etInfo.text.isNotBlank()) {
                obituarioDBHelper.anyadirDato(binding.etNombre.text.toString(),binding.etApellidos.text.toString(),
                    binding.etFecha.text.toString(), binding.etLugar.text.toString(), binding.etInfo.text.toString())
                binding.etId.text.clear()
                binding.etNombre.text.clear()
                binding.etApellidos.text.clear()
                binding.etFecha.text.clear()
                binding.etLugar.text.clear()
                binding.etInfo.text.clear()
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
            val db : SQLiteDatabase = obituarioDBHelper.readableDatabase
            val cursor = db.rawQuery(
                "SELECT * FROM obituario",
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
                        cursor.getString(3).toString()+ ", ")
                    binding.tvConsulta.append(
                        cursor.getString(4).toString()+ ", ")
                    binding.tvConsulta.append(
                        cursor.getString(5).toString() + "\n")
                } while (cursor.moveToNext())
            }

        }

        binding.btBorrar.setOnClickListener {

            var cantidad = 0

            if (binding.etId.text.isNotBlank()) {
                cantidad = obituarioDBHelper.borrarDato(
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
                binding.etFecha.text.isNotBlank() &&
                binding.etLugar.text.isNotBlank() &&
                binding.etInfo.text.isNotBlank() &&
                binding.etId.text.isNotBlank()) {
                obituarioDBHelper.modificarDato(
                    binding.etId.text.toString().toInt(),
                    binding.etNombre.text.toString(),
                    binding.etApellidos.text.toString(),
                    binding.etFecha.text.toString(),
                    binding.etLugar.text.toString(),
                    binding.etInfo.text.toString())
                binding.etNombre.text.clear()
                binding.etApellidos.text.clear()
                binding.etFecha.text.clear()
                binding.etLugar.text.clear()
                binding.etInfo.text.clear()
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