package com.cmm.gdh559

import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        val backHome: ImageButton = findViewById(R.id.backHome)

        backHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // ค้นหา WebView จาก XML
        val webView = findViewById<WebView>(R.id.mapWebView)

        // เปิดใช้งาน JavaScript
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // ให้ WebView โหลดแผนที่จาก Google Maps
        val mapUrl = "https://maps.app.goo.gl/eqJs3bw3UuNnRmsa6" // เปลี่ยนเป็นพิกัดของคุณ
        webView.webViewClient = WebViewClient() // ให้เปิดเว็บในแอป
        webView.loadUrl(mapUrl)


    }
}