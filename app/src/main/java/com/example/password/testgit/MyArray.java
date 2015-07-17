package com.example.password.testgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by password on 15-7-16.
 */
public class MyArray extends ArrayAdapter {

    Context mContext;
    List<String> mList;


    public MyArray(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    public void setData(Context context,List list){
        mContext=context;
        mList=list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){

                convertView = LayoutInflater.from(mContext).inflate(R.layout.my_item, null);

            viewHolder=new ViewHolder();
            convertView.setTag(viewHolder);
        }
        viewHolder=(ViewHolder)convertView.getTag();
        viewHolder.bindData();

        return convertView;
    }

    public class ViewHolder{

        public void bindData(){}
    }
}
