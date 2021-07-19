package com.myfirst.webviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initViews();
        mWebView.loadUrl(getIntent().getStringExtra("url"));
    }
    private void initViews() {
        mWebView = findViewById(R.id.webView);
    }
}