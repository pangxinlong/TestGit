package com.example.password.testgit;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by password on 15-11-24.
 * Description TODO
 */
public class TestActionBar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_action_bar);

//        SystemBarTintManager tintManager = new SystemBarTintManager(this);
//        // 设置一个颜色给系统栏
//        tintManager.setTintColor(Color.parseColor("#990000FF"));
//// 设置一个样式背景给导航栏
//        tintManager.setNavigationBarTintResource(R.drawable.ic_launcher);
// 设置一个状态栏资源
//        tintManager.setStatusBarTintDrawable(MyDrawable);


    }
}
