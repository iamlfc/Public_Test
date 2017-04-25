package com.ruanmeng.project_model.gitview.web_progress;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ruanmeng.project_model.R;

public class MyProgress_WebView extends AppCompatActivity {
    private ProgressWebView progressWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progress__web_view);



        progressWeb = (ProgressWebView) findViewById(R.id.progress_web);

        progressWeb.loadUrl("www.baidu.com");
    }

    private WebViewClient  webViewClient=new WebViewClient()
    {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl("www.baidu.com");
            return super.shouldOverrideUrlLoading(view, request);
        }
    };
}
