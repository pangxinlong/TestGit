package com.example.password.testgit;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    SpinnerAdapter mSpinnerAdapter;
    List<String> mArrayList;
    MyArrayAdpter mArrayAdapter;
    Spinner spinner;
    PopupWindow mPopupWindow;
    ListView mListView;
        BaseAdapter b;

    MyArrayAdpter myArrayAdpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         spinner=(Spinner)findViewById(R.id.spinner);
        mListView=(ListView)findViewById(R.id.mListView);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mArrayList=new ArrayList<>();
        for(int i=0;i<10;i++){
            mArrayList.add(i+"");
        }







         myArrayAdpter=new MyArrayAdpter(this,mArrayList);

//        spinner.setOnClickListener(this);
//        mListView = new ListView(getApplicationContext());
        mListView.setAdapter(myArrayAdpter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(mPopupWindow!=null){
//                    mPopupWindow.dismiss();
//                    mPopupWindow=null;
//                }
////                spinner.setText(mArrayList.get(position));
//            }
//        });

//        mArrayAdapter=new MyArrayAdpter(this,mArrayList);
//        spinner.setAdapter(mArrayAdapter);

//        arrayAdapter=new MyArray(this,R.layout.default_item,mArrayList);
//        arrayAdapter.setData(this,mArrayList);
//        spinner.setAdapter(arrayAdapter);

//        mArrayList=null;
//        if(mArrayList!=null){
//            MySpinnerAdapter mySpinnerAdapter=new MySpinnerAdapter(this,mArrayList);
//            spinner.setAdapter(mySpinnerAdapter);
//        }
        mListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(myArrayAdpter.getCurrentSelection() != position){
            myArrayAdpter.setSelections(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mymenu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mymenu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



//    @Override
//    public void onClick(View v) {
//        if(mPopupWindow==null){
//            mPopupWindow=new PopupWindow(mListView);
//            mPopupWindow.setWidth(spinner.getWidth());
//            mPopupWindow.setHeight(200);
//            mPopupWindow.setOutsideTouchable(true);// 是否允许popupWindow之外部分能点击
//            mPopupWindow.setFocusable(true);
//        }
//        mPopupWindow.showAsDropDown(spinner);
//    }

//    /**
//     * 触摸Activity其他地方popup消失,注意要把这个时间消费掉
//     */
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        System.out.println("aaabvbbcc");
//        if (mPopupWindow != null) {
//            mPopupWindow.dismiss();
//            mPopupWindow = null;
//        }
//        return true;
//    }

    class MyAdatper extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("======dpxl===",event.getX()+"");
        return super.onTouchEvent(event);
    }


}
