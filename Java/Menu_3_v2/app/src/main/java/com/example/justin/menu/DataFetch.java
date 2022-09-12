package com.example.justin.menu;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Justin on 9/21/2015.
 */
public class DataFetch extends AsyncTask<Void, Void, HelloGreetingCollection> {
    @Override
    protected HelloGreetingCollection doInBackground(Void... unused) {
        // Retrieve service handle using null credential since this is an unauthenticated call.
        Helloworld apiServiceHandle = AppConstants.getApiServiceHandle(null);

        try {
            ListGreeting getGreetingCommand = apiServiceHandle.greetings().listGreeting();
            HelloGreetingCollection greeting = getGreetingCommand.execute();
            return greeting;
        } catch (IOException e) {
            Log.e(LOG_TAG, "Exception during API call", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(HelloGreetingCollection greeting) {
        if (greeting!=null && greeting.getItems()!=null) {
            displayGreetings(greeting.getItems().toArray(new HelloGreeting[] {}));
        } else {
            Log.e(LOG_TAG, "No greetings were returned by the API.");
        }
    }
};

}
