package com.baidu.tts.sample.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.baidu.tts.sample.R;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class WebViewActivity extends Activity {

    private WebView mWebView =null;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_3d);


        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new HelloWebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://yyandhgforever.pw/3D/");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //定义一个载入webview的内部类
    private class HelloWebViewClient extends WebViewClient {
        private static final String TAG = "HelloWebViewClient";;

        // Give application a chance to catch additional URL loading requests
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i(TAG, "About to load:" + url);
            view.loadUrl(url);
            return true;
        }
    }


}
