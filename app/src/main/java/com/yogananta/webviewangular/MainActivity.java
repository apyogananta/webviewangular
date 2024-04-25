package com.yogananta.webviewangular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView _webview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _webview1 = (WebView) findViewById(R.id.webviewangular);

        WebViewClient webViewClient = new WebViewClient();
        _webview1.setWebViewClient(webViewClient);

        WebChromeClient webChromeClient = new WebChromeClient();
        _webview1.setWebChromeClient(webChromeClient);

        WebSettings webSettings = _webview1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        WebAppInterface webAppInterface = new WebAppInterface(this,MainActivity.this);
        _webview1.addJavascriptInterface(webAppInterface, "Android");

        String url = "https://stmikpontianak.net/011100862/angular011100862";
        _webview1.loadUrl(url);
    }

}