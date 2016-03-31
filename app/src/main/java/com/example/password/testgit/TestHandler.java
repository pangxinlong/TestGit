package com.example.password.testgit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by pxl on 15-12-8.
 * Description 测试webview
 */
public class TestHandler extends Activity {

    Handler handler;
    private boolean isfirst=true;
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_webview);
        webview=(WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
//        initView();
        loadWebView();
//        Uri uri = Uri.parse("test://test.uri.activity?action=1");
//        Intent intent = new Intent("com.example.password.testgit.TestOpenApp");
//        intent.setData(uri);
//        startActivity(intent);
        NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder;
        builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
                .setContentTitle("harvic")
                .setContentText("test schemeURL")
                .setTicker("有新消息")
                .setOngoing(false)
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        Uri uri = Uri.parse("qijian://test.uri.activity?action=1");
        Intent intent = new Intent("android.qijian.schemeurl.activity");
        intent.setData(uri);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        notifyManager.notify(1111, notification);
    }

    private void loadWebView(){
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("pxl=====shouldUrl","is running");
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description,
                    String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
//                webview.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        webview.loadUrl("javascript:testSetData()");
//                    }
//                });
//
                if(isfirst){
                    isfirst=false;
                    webview.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            webview.loadUrl("http://news.baidu.com/");
                        }
                    },5000);
                }
                super.onPageFinished(view, url);
            }
        });

        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }


        });

        webview.loadUrl("http://www.baidu.com");
    }

//    private void initView() {
//        handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                switch (msg.what) {
//                    case 1:
//                        Log.e("reciver handler ====1","===is running");
//                        handler.sendEmptyMessageDelayed(2,4000);
//                        sendMessage2();
//                        break;
//                    case 2:
//                        Log.e("reciver handler =====2","===is running");
//                        handler.removeMessages(2);
//                        break;
//                }
//            }
//        };
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(1);
//            }
//        }).start();
//    }
//
//    private void sendMessage2(){
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessageDelayed(2,5000);
//            }
//        });
//        thread.start();
//    }


}

