package com.example.justin.menu;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.appspot.menu.menuitems.Menuitems;
import com.appspot.menu.menuitems.model.MenuDescriptionCollection;

import java.io.IOException;

/**
 * Created by Justin on 6/19/2015.
 */
public class DescriptionFetch extends AsyncTask<Void, Void, MenuDescriptionCollection>{
    private static final String LOG_TAG = "CourseSelection";

    @Override
    protected MenuDescriptionCollection doInBackground(Void... unused) {
        Menuitems apiServiceHandle = AppConstants.getApiServiceHandle(null);
        try {
            Menuitems.Description.Sandwiches getDescriptionCommand = apiServiceHandle.description().sandwiches();
            MenuDescriptionCollection sandwich_description = getDescriptionCommand.execute();
            return sandwich_description;
        } catch (IOException e) {
            Log.e(LOG_TAG, "Exception during API call", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(MenuDescriptionCollection sandwich_description) {
        if (sandwich_description!=null && sandwich_description.getItems()!=null) {
            String text = sandwich_description.getItems().toString();
            //Resources res = getResources();
           // TextView text1 = (TextView) findViewById(R.id.sandwich_description);
            //text1.setText(text);
        } else {
            Log.e(LOG_TAG, "No greetings were returned by the API.");
        }
    }
}
