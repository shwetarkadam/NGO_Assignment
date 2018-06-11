package com.example.hp.awaazngo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DonateUsFragment extends Fragment {

    public DonateUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_donate_us, container, false);
        final WebView mWebView = (WebView) v.findViewById(R.id.webview);


        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                mWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('nav').style.display='none'; " +
                        "var head = document.getElementById('footer').style.display='none'; " +
                        "var head = document.getElementById('copyright').style.display='none'; " +
                        "})()");
            }
        });
        mWebView.loadUrl("http://www.awaazngo.com");
return v;
    }


}
