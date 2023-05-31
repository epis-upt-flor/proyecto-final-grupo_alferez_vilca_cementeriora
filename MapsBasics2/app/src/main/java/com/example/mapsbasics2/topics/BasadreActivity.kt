package com.example.mapsbasics2.topics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.mapsbasics2.R
import com.example.mapsbasics2.R.id.navegador2

class BasadreActivity : AppCompatActivity(){

    private var navegador2:WebView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basadrewk)

        navegador2 = findViewById(R.id.navegador2)

        val webView = findViewById<WebView>(R.id.navegador2)
        webView.loadUrl("https://es.wikipedia.org/wiki/Jorge_Basadre")
        navegador2?.clearCache(false)
        navegador2?.settings?.javaScriptEnabled=true
    }
}