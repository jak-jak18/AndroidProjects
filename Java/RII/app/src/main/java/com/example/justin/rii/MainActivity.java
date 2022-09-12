package com.example.justin.rii;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appspot.justin_katzwhite_resume.resume.Resume;
import com.appspot.justin_katzwhite_resume.resume.model.ResumeData;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        question1();
        //question2();
    }

    public void question1(){

        Resume apiServiceHandle = AppConstants.getApiServiceHandle(null);

        try{
            Resume.List.BI listBiCommand = apiServiceHandle.list().bI();
            ResumeData resumeData = listBiCommand.execute();

        }catch (IOException e){
            Log.e(LOG_TAG, "Exception during API call", e);
        }
    }

    final void question10(){}

    public void question2(){
        RelativeLayout view = (RelativeLayout) findViewById(R.id.main_activity);
        view.addView(null);
    }

    public class example extends BaseAdapter{
        @Override
        public int getCount() {
            mDbHelper = new DbHelper(context);
            cursor = queryData(menu_selected);

            return cursor.getCount();
        }

        @Override
        public Menu getItem(int position) {
            return menu[position];
        }

        @Override
        public long getItemId(int position) {
            return Menu.data[0];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

        }

    }

}
