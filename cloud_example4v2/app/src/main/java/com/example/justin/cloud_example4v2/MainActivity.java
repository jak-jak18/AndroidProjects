package com.example.justin.cloud_example4v2;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    AsyncTask<Tester, Void, HelloGreetingCollection> getAndDisplayGreeting =
            new AsyncTask<Tester, Void, HelloGreetingCollection> () {
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

            };


}