package com.example.android.uclapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl("https://uclapi.com/oauth/authorise?client_id=1602067753800377.1993571231878480&client_secret=e1b3bedfda05c8508a0c39d378337c1ec44b24d2451f55fac0626a744a3c7794&state=deadbeef");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url){
                view.loadUrl("javascript:(function() { " +
                        "document.getElementById('header header--desktop')[0].style.display='none'; " +
                        "})()");
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });

        //Toast.makeText(this, "Opened Webpage", Toast.LENGTH_SHORT).show();

        ImageView imageView = (ImageView)findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomeScreen.class);
                startActivity(intent);
            }
        });
    }
}


