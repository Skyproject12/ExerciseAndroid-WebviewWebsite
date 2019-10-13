package com.example.webviewwebsite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview= findViewById(R.id.webview);
        // meminta permission berkaitan javascript
        webview.getSettings().setJavaScriptEnabled(true);
        // berfungsi untuk melakukan konfigurasi webclient
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:alert('web dicoding berhasil dimuat')");
                Toast.makeText(MainActivity.this, "Web dicoding berhasil dimuat", Toast.LENGTH_SHORT).show();
            }
        });
        // webChromeClient berfungsi untuk menampilkan alert yang dikirim dari fungsi loadurl
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                // berfungsi webChromeCliecnt dapat menampilkan loading ketika halaman dibuat
                Toast.makeText(MainActivity.this, message , Toast.LENGTH_SHORT).show();
                result.confirm();
                return true;
            }
        });
        // mengakses suatu website yang di inginkan
        webview.loadUrl("https://www.dicoding.com");
    }
}
