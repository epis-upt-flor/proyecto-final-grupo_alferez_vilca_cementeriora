package com.example.mapsbasics2.ilustres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.mapsbasics2.MainActivity
import com.example.mapsbasics2.R

class ctacna : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ctacna)

        val button: ImageButton = findViewById(R.id.menuboton2)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}

        val button1: ImageButton = findViewById(R.id.menuboton)
        button1.setOnClickListener {
            val intent = Intent(this, ssors::class.java)
            startActivity(intent)}

        val button3: ImageButton = findViewById(R.id.menuboton3)
        button3.setOnClickListener {
            val intent = Intent(this, jbasadre::class.java)
            startActivity(intent)}



        val textView0 = findViewById<TextView>(R.id.textView14)
        val textView1 = findViewById<TextView>(R.id.textView15)
        val textView2 = findViewById<TextView>(R.id.textView16)
        val textView3 = findViewById<TextView>(R.id.textView17)

        textView0.text = "\nInauguración: 17 de Agosto de 1848, Tacna"
        textView1.text = "Propietario: Sociedad de Beneficencia Pública de Tacna"
        textView2.text = "Fundador: Sebastián Ramón Sors\n"
        textView3.text = "El cementerio se inauguró en una época de oro de Tacna, en pleno auge del comercio que se mantenía con el Alto Perú y el norte argentino.\n" + "Su construcción se debe a la iniciativa de uno de los sacerdotes que llegaron a Tacna, el español Sebastián Ramón Sors quien orientó y dirigió la construcción.\n" + "También impulsó varias obras públicas y tuvo una actuación heroica atendiendo a los enfermos de la terrible fiebre amarilla que acabó con un tercio de la población tacneña, en 1868.\n" + "Los tacneños agradecidos erigieron un mausoleo, en el que reposan sus restos, con un busto que lo recuerda.\n" + "Esta obra, construida en fino mármol, se inauguró el 29 de junio de 1885, apenas concluida la Guerra con Chile, en los primeros años del cautiverio de Tacna.\n"
    }
}