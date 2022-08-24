package com.example.justin.resume_v1;

import android.os.AsyncTask;
import android.util.Pair;
import android.util.Log;
import android.widget.TextView;

import com.appspot.justin_katzwhite_resume.resume.Resume;
import com.appspot.justin_katzwhite_resume.resume.model.ResumeData;
import com.appspot.justin_katzwhite_resume.resume.model.ResumeProperties;

import java.io.IOException;

/**
 * Created by Justin on 11/11/2015.
 */
public class DataFetch extends AsyncTask<Pair<String,String>, Void, String> {
    private static final String LOG_TAG = "DataFetch";

    ResumeProperties resumeProperties;
    String Data;
    //    String request = "data";
//    String request = "data 2";
    ResumeProperties query;

    TextView textView;

    public DataFetch(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Pair<String,String>... params) {
        Log.d(LOG_TAG, "request: " + params[0].second);

        Resume apiServiceHandle = AppConstants.getApiServiceHandle(null);
        query = new ResumeProperties().setText(params[0].second);

        if (params[0].first == "BI"){
            try {
                Resume.List.BI listBiCommand = apiServiceHandle.list().bI(query);
                ResumeData resumeData = listBiCommand.execute();

                resumeProperties = resumeData.getData().get(0);
                Data = resumeProperties.getText();

                return Data;

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }

        }else if(params[0].first == "PL"){
            try {
                Resume.List.PL listPlCommand = apiServiceHandle.list().pL(query);
                ResumeData resumeData = listPlCommand.execute();

                resumeProperties = resumeData.getData().get(0);
                Data = resumeProperties.getText();

                return Data;

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }
        }
        return Data;
    }

    @Override
    protected void onPostExecute(String data) {
        if (data!=null) {
            textView.setText(data);

        } else {
            Log.e(LOG_TAG, "No menus were returned by the API.");
        }
    }
}
