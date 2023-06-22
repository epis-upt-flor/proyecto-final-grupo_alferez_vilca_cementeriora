package com.example.mapsbasics2.topics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.mapsbasics2.MainActivity
import com.example.mapsbasics2.R
import com.example.mapsbasics2.ilustres.ctacna
import com.example.mapsbasics2.ilustres.fbarreto
import com.example.mapsbasics2.ilustres.gvigil
import com.example.mapsbasics2.ilustres.jbasadre

class IlustresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ilustres)

        val buttonpag2: ImageButton = findViewById(R.id.imageButton2)
        buttonpag2.setOnClickListener {
            val intent = Intent(this, Ilustres2Activity::class.java)
            startActivity(intent)}

        val buttonhome: ImageButton = findViewById(R.id.imageButton)
        buttonhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}

        val button: Button = findViewById(R.id.ctacnaboton)
        button.setOnClickListener {
            val intent = Intent(this, ctacna::class.java)
            startActivity(intent)}

        val button2: Button = findViewById(R.id.jbasadreboton)
        button2.setOnClickListener {
            val intent = Intent(this, jbasadre::class.java)
            startActivity(intent)}

        val button3: Button = findViewById(R.id.gvigilboton)
        button3.setOnClickListener {
            val intent = Intent(this, gvigil::class.java)
            startActivity(intent)}

        val button4: Button = findViewById(R.id.fbarretoboton)
        button4.setOnClickListener {
            val intent = Intent(this, fbarreto::class.java)
            startActivity(intent)}


    }
}