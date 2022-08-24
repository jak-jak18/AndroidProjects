package com.example.justin.cloud_example4v2;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Justin on 4/23/2015.
 */
public class EndpointsAsyncTask extends AsyncTask<Tester, Void, HelloGreetingCollection> {

                @Override
                protected HelloGreetingCollection doInBackground(Tester... params) {
                    // Retrieve service handle.
                    Tester apiServiceHandle = AppConstants.getApiServiceHandle();

                    try {
                        Tester.Datasend getGreetingCommand = apiServiceHandle.datasend();
                        HelloGreetingCollection greeting = getGreetingCommand.execute();
                        return greeting;
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "Exception during API call", e);
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(HelloGreetingCollection greeting) {
                    if (greeting!=null) {
                    } else {
                        Log.e(LOG_TAG, "No data wuz returned by da API.");
                    }
                }



}
