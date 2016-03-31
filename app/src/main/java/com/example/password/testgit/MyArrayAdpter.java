package com.example.password.testgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by password on 15-7-10.
 */
public class MyArrayAdpter extends BaseAdapter {

    int currentSelection = 0;


    Context mContext;
    List<String> mList;

    public MyArrayAdpter(Context context,List list){
        mContext=context;
        mList=list;
    }

    public int getCurrentSelection() {
        return this.currentSelection;
    }

    public void setSelections(int position) {
        currentSelection = position;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
//            if(position==0){
//                convertView= LayoutInflater.from(mContext).inflate(R.layout.default_item,null);
//            }else {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.my_item, null);
//            }
            viewHolder=new ViewHolder();
            viewHolder.textView=(TextView)convertView.findViewById(R.id.textView);
            viewHolder.rootView=convertView.findViewById(R.id.rootView);

            convertView.setTag(viewHolder);
        }
        viewHolder=(ViewHolder)convertView.getTag();
        viewHolder.bindData(position);
        if(currentSelection==position){
            viewHolder.rootView.setBackgroundResource(R.color.red);
        }else {
            viewHolder.rootView.setBackgroundResource(R.drawable.listitem_selector);
        }

        return convertView;
    }

    public class ViewHolder{

        View rootView;

        TextView textView;
        public void bindData(int position){

        }
    }
}
