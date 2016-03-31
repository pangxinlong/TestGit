package com.example.password.testgit;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by password on 15-9-28.
 * Description TODO
 */
public class TestSharedPreferencesActivity extends Activity {

    EditText mEditText;

    TextView mTextViewShow;

    Button mButtonShow, mButtonSave;


//    MyCustomView mtvLimitText;

    public static final String DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
        initView();
        setListener();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.et_content);
        mTextViewShow = (TextView) findViewById(R.id.tv_show);
        mButtonSave = (Button) findViewById(R.id.btn_save);
        mButtonShow = (Button) findViewById(R.id.btn_show);

//        mtvLimitText=(MyCustomView)findViewById(R.id.tv_limit_text);
    }

    private void setListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_save:
                        saveInfo();
                        break;
                    case R.id.btn_show:
                        showInfo();
                        break;
                }
            }
        };
        mButtonSave.setOnClickListener(onClickListener);
        mButtonShow.setOnClickListener(onClickListener);


    }

    private void saveInfo() {
        SharedPreferences sharedPreferences
                = getSharedPreferences(DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("content", mEditText.getText().toString());
        edit.commit();
    }

    private void showInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences(DATA, Context.MODE_PRIVATE);
        mTextViewShow.setText(sharedPreferences.getString("content", ""));
    }
}
