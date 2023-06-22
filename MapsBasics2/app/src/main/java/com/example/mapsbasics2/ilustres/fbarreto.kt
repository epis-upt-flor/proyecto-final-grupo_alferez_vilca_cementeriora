package com.example.mapsbasics2.ilustres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.mapsbasics2.MainActivity
import com.example.mapsbasics2.R

class fbarreto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fbarreto)

        val button: ImageButton = findViewById(R.id.menuboton2)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}

        val button1: ImageButton = findViewById(R.id.menuboton)
        button1.setOnClickListener {
            val intent = Intent(this, gvigil::class.java)
            startActivity(intent)}

        val button3: ImageButton = findViewById(R.id.menuboton3)
        button3.setOnClickListener {
            val intent = Intent(this, fzora::class.java)
            startActivity(intent)}

        val textView0 = findViewById<TextView>(R.id.textView14)
        val textView1 = findViewById<TextView>(R.id.textView15)
        val textView2 = findViewById<TextView>(R.id.textView16)
        val textView3 = findViewById<TextView>(R.id.textView17)

        textView0.text = "\nNacimiento: 12 de febrero de 1903, Tacna"
        textView1.text = "Fallecimiento: 29 de junio de 1980, Lima"
        textView2.text = "Profesión: Historiador e Historiógrafo Peruano\n"
        textView3.text = "Jorge Basadre Grohmann fue un destacado historiador peruano, bajo administración chilena en ese entonces.\n Su infancia estuvo marcada por el ambiente de lucha y defensa de la identidad peruana en Tacna. " +
                "Realizó sus estudios en Lima y se graduó en Letras y Derecho en la Universidad Nacional Mayor de San Marcos.\n " +
                "Basadre tuvo una destacada carrera académica y profesional, ocupando cargos como catedrático, director de bibliotecas y ministro de Educación.\n " +
                "Fue reconocido por su labor en la reconstrucción de la Biblioteca Nacional del Perú y por su amplia investigación historiográfica.\n " +
                "Dejando un legado importante en el campo de la historia peruana.\n"
    }
}