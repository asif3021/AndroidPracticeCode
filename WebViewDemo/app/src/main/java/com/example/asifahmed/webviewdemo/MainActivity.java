package com.example.asifahmed.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webViewId);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());


          webView.loadUrl("http://courier.exponentsolution.com/casadmin");
//        webView.loadUrl("http://raowa.exponentsolution.com/");
//        webView.loadUrl("http://daffodilvarsity.edu.bd/");



    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
