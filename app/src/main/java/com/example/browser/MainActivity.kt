package com.example.browser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.myWebView)
        val etSearch: EditText = findViewById(R.id.tvSearch)
        val btnSearch:  Button = findViewById(R.id.btnSearch)
        val ivTwitter: ImageView = findViewById(R.id.ivTwitter)
        val ivInsta: ImageView = findViewById(R.id.ivInsta)
        val ivGoogle: ImageView = findViewById(R.id.ivGoogle)
        val ivFacebook: ImageView = findViewById(R.id.ivFacebook)

        btnSearch.setOnClickListener{
            val url:String = etSearch.text.toString()
            if (URLUtil.isValidUrl(url))
            {
                myWebView.loadUrl(url)
            }
            else
            {
                myWebView.loadUrl("https://www.google.com/search?q=$url")
            }

        }

        ivTwitter.setOnClickListener{
            myWebView.loadUrl("https://twitter.com/?lang=en")
        }

        ivInsta.setOnClickListener{
            myWebView.loadUrl("https://www.instagram.com/")
        }

        ivGoogle.setOnClickListener{
            myWebView.loadUrl("https://www.google.com/")
        }

        ivFacebook.setOnClickListener{
            myWebView.loadUrl("https://www.facebook.com/")
        }

        myWebView.loadUrl("https://www.google.com/")
        myWebView.webViewClient = WebViewClient()
        myWebView.settings.javaScriptEnabled = true

    }
}