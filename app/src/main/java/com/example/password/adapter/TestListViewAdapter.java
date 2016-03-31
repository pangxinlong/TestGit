package com.example.password.adapter;

import com.example.password.testgit.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by password on 15-11-16.
 * Description TODO
 */
public class TestListViewAdapter extends BaseAdapter {

    private Context mContext;
    public TestListViewAdapter(Context context){
        mContext=context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.test_list_view_item,parent,false);
        }
        return convertView;
    }
}
