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

        textView0.text = "\nNacimiento: 8 de febrero de 1868, Tacna"
        textView1.text = "Fallecimiento: 30 de Octubre de 1929, Francia"
        textView2.text = "Profesión: Poeta y Periodista Peruano\n"
        textView3.text = "Federico Barreto Bustíos fue un poeta peruano conocido como «El cantor del cautiverio» o «El poeta del cautiverio».\n Vivió en Tacna durante la ocupación chilena que siguió a la Guerra del Pacífico y llevó a cabo una intensa vida intelectual y periodística, abogando por la peruanidad de los territorios ocupados por Chile y oponiéndose a la chilenización." + "Fue miembro fundador del semanario El Progresista (1886) y del Círculo Vigil (1888).\n" + " Con su hermano José María, integró el grupo literario llamado La Bohemia Tacneña, en cuya revista literaria Letras colaboraron, entre 1896 y 1898, escritores como Rubén Darío, Clemente Palma, José Enrique Rodó y José Santos Chocano.\n" + "Con su hermano Federico María Barreto fue codirector del diario La Voz del Sur. En 1911 una turba chilena destruyó las imprentas que publicaban los dos diarios peruanos de Tacna: La Voz del Sur y El Tacora.\n"
    }
}