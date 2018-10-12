package com.market.pingan.iemcore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView main_webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_webview = (WebView) findViewById(R.id.webview_index);
        main_webview.getSettings().setJavaScriptEnabled(true);
        main_webview.loadUrl("https://iem-core-stg.paic.com.cn/iem-core/iem_main.html");
        main_webview.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {        if (
                main_webview.canGoBack()) {
                main_webview.goBack();
                return true; }
                else {
                System.exit(0);     }
        }
                return super.onKeyDown(keyCode, event);



    }
}
