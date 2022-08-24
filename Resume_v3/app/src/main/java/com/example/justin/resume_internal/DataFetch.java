package com.example.justin.resume_internal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.appspot.justin_katzwhite_resume.resume.Resume;
import com.appspot.justin_katzwhite_resume.resume.model.ResumeData;
import com.appspot.justin_katzwhite_resume.resume.model.ResumeProperties;

import java.io.IOException;

/**
 * Created by Justin on 11/11/2015.
 */
public class DataFetch extends AsyncTask<Pair<String,String>, Void, String> {
    private static final String LOG_TAG = "DataFetch";

    public DataFetch(Activity activity, LinearLayout linearLayout, SQLiteDatabase db) {
        this.activity = activity;
        this.linearLayout = linearLayout;
        textView = (TextView) linearLayout.getChildAt(0);
        this.db = db;
    }

    ResumeProperties resumeProperties;
    String Data;

    LinearLayout linearLayout;
    SQLiteDatabase db;
    ContentValues values = new ContentValues();
    String key;
    Activity activity;

    @Override
    protected String doInBackground(Pair<String,String>... params) {
        Log.d(LOG_TAG, "request: " + params[0].second);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ProgressBar progressBar = new ProgressBar(activity.getApplicationContext());
                int wrap = ViewGroup.LayoutParams.WRAP_CONTENT;
                progressBar.setLayoutParams(new ViewGroup.LayoutParams(wrap,wrap));
                linearLayout.removeViewAt(0);
                linearLayout.addView(progressBar);
            }
        });

        Resume apiServiceHandle = AppConstants.getApiServiceHandle(null);

        if (params[0].first == "BI"){
            try {
                Resume.List.BI listBiCommand = apiServiceHandle.list().bI();
                ResumeData resumeData = listBiCommand.execute();

                resumeProperties = resumeData.getData().get(0);
                Data = resumeProperties.getText();

                return Data;

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }

        }else if(params[0].first == "PL"){
            try {
                key = params[0].second;
                Resume.List.PL listPlCommand = apiServiceHandle.list().pL(key);
                ResumeData resumeData = listPlCommand.execute();

                resumeProperties = resumeData.getData().get(0);
                Data = resumeProperties.getText();

                values.put(Columns.Titles.KEY, key);
                values.put(Columns.Titles.VALUE, Data);

                long newRowId = db.insert(
                        Columns.Titles.TABLE_NAME,
                        Columns.Titles.COLUMN_NAME_NULLABLE,
                        values);

                if (newRowId == -1){
                    Log.d(LOG_TAG, "Data input failed. :(");
//                    Toast.makeText(context, "Data input failed. :(", Toast.LENGTH_SHORT).show();
                }else{
                    Log.d(LOG_TAG, "Data retrieved and stored in database. Row id: " + newRowId);
//                    Toast.makeText(context, "Data retrieved and stored in database. Row id: " + newRowId, Toast.LENGTH_SHORT).show();
                }

                return Data;

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }
        }

        return Data;
    }

    TextView textView;

    @Override
    protected void onPostExecute(String data) {
        if (data!=null) {
//            Log.d(LOG_TAG, "Data returned: " + data);
            textView.setText(data);

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    linearLayout.removeViewAt(0);
                    linearLayout.addView(textView);
                }
            });

        } else {
            Log.e(LOG_TAG, "No menus were returned by the API.");
        }
    }
}
