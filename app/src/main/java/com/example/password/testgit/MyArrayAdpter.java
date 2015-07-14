package com.example.password.testgit;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by password on 15-7-10.
 */
public class MyArrayAdpter extends ArrayAdapter {

    Context mContext;
    List<String> mList;


    public MyArrayAdpter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mList=objects;
    }


}
