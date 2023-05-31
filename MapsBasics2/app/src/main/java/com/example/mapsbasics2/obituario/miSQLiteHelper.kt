package com.example.mapsbasics2.obituario

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "obituario.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE obituario " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT, apellidos TEXT, fecha TEXT, lugar TEXT)"
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS obituario"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun anyadirDato(nombre: String, apellidos: String, fecha: String, lugar: String) {
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("apellidos", apellidos)
        datos.put("fecha", fecha)
        datos.put("lugar", lugar)

        val db = this.writableDatabase
        db.insert("obituario", null, datos)
        db.close()
    }

    fun borrarDato(id: Int) : Int {
        val args = arrayOf(id.toString())

        val db = this.writableDatabase
        val borrados = db.delete("obituario", "_id = ?", args)
        // db.execSQL("DELETE FROM obituario WHERE id = ?", args)
        db.close()
        return borrados
    }

    fun modificarDato(id: Int, nombre: String, apellidos: String, fecha: String, lugar: String) {
        val args = arrayOf(id.toString())

        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("apellidos", apellidos)
        datos.put("fecha", fecha)
        datos.put("lugar", lugar)

        val db = this.writableDatabase
        db.update("obituario", datos, "_id = ?", args)
        db.close()
    }
}