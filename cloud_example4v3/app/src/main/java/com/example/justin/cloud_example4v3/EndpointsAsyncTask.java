package com.example.justin.cloud_example4v3;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Justin on 4/23/2015.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, HelloGreetingCollection> {
    private Context context;
    private static final String LOG_TAG = "EndpointsAsyncTask";
    @Override
    protected HelloGreetingCollection doInBackground(Void... unused) {
        // Retrieve service handle.
        Tester apiServiceHandle = AppConstants.getApiServiceHandle();

        try {
            Tester.Datasend getGreetingCommand = apiServiceHandle.datasend();
            HelloGreetingCollection greeting = getGreetingCommand.execute();
            return greeting;
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    protected void onPostExecute(HelloGreetingCollection greeting) {
        displayGreetings(greeting);
    }

    private void displayGreetings(HelloGreetingCollection... greetings) {
            Toast.makeText(this, greetings, Toast.LENGTH_LONG).show();
            Log.i(LOG_TAG, "Here is the " + greetings);
        }
}
