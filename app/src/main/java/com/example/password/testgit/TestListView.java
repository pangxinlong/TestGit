package com.example.password.testgit;

import com.example.password.adapter.TestListViewAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by password on 15-11-16.
 * Description TODO
 */
public class TestListView extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_test_list_view);
        EditText editText = (EditText) findViewById(R.id.et_edit);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        initView();
    }

    private void initView() {
        final ListView listView = (ListView) findViewById(R.id.lv_test);
        listView.setAdapter(new TestListViewAdapter(TestListView.this));
    }
}
