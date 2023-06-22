package com.example.mapsbasics2.topics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.mapsbasics2.MainActivity
import com.example.mapsbasics2.R

class Ilustres2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ilustres2)

        val buttonpag2: ImageButton = findViewById(R.id.imageButton2)
        buttonpag2.setOnClickListener {
            val intent = Intent(this, IlustresActivity::class.java)
            startActivity(intent)}

        val buttonhome: ImageButton = findViewById(R.id.imageButton)
        buttonhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}

    }
}