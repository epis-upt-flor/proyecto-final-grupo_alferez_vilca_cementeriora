package com.example.mapsbasics2.ilustres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.mapsbasics2.MainActivity
import com.example.mapsbasics2.R

class gvigil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gvigil)

        val button: ImageButton = findViewById(R.id.menuboton2)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}

        val textView0 = findViewById<TextView>(R.id.textView14)
        val textView1 = findViewById<TextView>(R.id.textView15)
        val textView2 = findViewById<TextView>(R.id.textView16)
        val textView3 = findViewById<TextView>(R.id.textView17)

        textView0.text = "\nNacimiento: 13 de Setiembre de 1792, Tacna"
        textView1.text = "Fallecimiento: 9 de junio de 1875, Lima"
        textView2.text = "Profesión: Clérigo, político, periodista, educador, escritor\n"
        textView3.text = "Francisco de Paula González-Vigil Yáñez o simplemente, Vigil, fue un clérigo, político e intelectual peruano. Fue uno de los más tenaces representantes del liberalismo político en medio de la anarquía y el caudillismo en que se debatía la naciente república peruana.\n " + "Fue elegido ocho veces diputado y una vez senador ante el Congreso de la República del Perú. Destacó por sus dotes de orador.\n" + " Como vicepresidente de la Cámara de Diputados se hizo célebre por su famoso discurso titulado Yo acuso, pronunciado el 2 de noviembre de 1832 en la sede legislativa, denunciando al presidente de la República Agustín Gamarra por haber violado la Constitución.\n " + "Escribió obras muy extensas defendiendo la separación de la Iglesia del Estado. Llegó a sufrir la excomunión papal en tres ocasiones sin retractarse jamás de sus ideas, y seis de sus libros fueron incluidos por la Santa Sede en el Índice de Libros Prohibidos, en vida del autor.\n"
    }
}