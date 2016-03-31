package com.example.password.testgit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by pxl on 16-2-16.
 * Description TODO
 */
public class TestOpenApp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_open_app);
        initData();
    }


    private void initData() {
        Intent intent = getIntent();
        Uri uri=intent.getData();

        if (uri!=null) {
            String tagurl=uri.getQueryParameter("url");
            if(tagurl!=null&&tagurl.equals("tag_url")){
                Intent intent1 = new Intent(this, TestPhotoActivity.class);
                this.startActivity(intent1);
            }

        }
    }
}
