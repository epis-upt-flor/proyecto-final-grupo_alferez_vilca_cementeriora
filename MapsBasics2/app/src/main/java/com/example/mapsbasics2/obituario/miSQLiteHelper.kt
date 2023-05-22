package com.example.mapsbasics2.obituario

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "amigos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE amigos " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT, apellidos TEXT, email TEXT)"
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS amigos"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun anyadirDato(nombre: String, apellidos: String, email: String) {
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("apellidos", apellidos)
        datos.put("email", email)

        val db = this.writableDatabase
        db.insert("amigos", null, datos)
        db.close()
    }

    fun borrarDato(id: Int) : Int {
        val args = arrayOf(id.toString())

        val db = this.writableDatabase
        val borrados = db.delete("amigos", "_id = ?", args)
        // db.execSQL("DELETE FROM amigos WHERE id = ?", args)
        db.close()
        return borrados
    }

    fun modificarDato(id: Int, nombre: String, apellidos: String,email: String) {
        val args = arrayOf(id.toString())

        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("apellidos", apellidos)
        datos.put("email", email)

        val db = this.writableDatabase
        db.update("amigos", datos, "_id = ?", args)
        db.close()
    }
}