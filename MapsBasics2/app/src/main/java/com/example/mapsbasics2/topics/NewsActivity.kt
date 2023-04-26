package com.example.mapsbasics2.topics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.mapsbasics2.R

class NewsActivity : AppCompatActivity() {

    private var navegador:WebView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        navegador = findViewById(R.id.navegador)

        val webView = findViewById<WebView>(R.id.navegador)
        webView.loadUrl("https://diocesisdetacnaymoquegua.org/category/noticias-diocesanas/")
        navegador?.clearCache(false)
        navegador?.settings?.javaScriptEnabled=true
    }
}