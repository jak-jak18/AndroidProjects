package com.example.justin.cloud_example4v3;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncTask msg1 = new EndpointsAsyncTask().execute();
        String msg = "Hey Everybody";
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        AsyncTask<Void, Void, HelloGreetingCollection> getGreetingAndDisplay =
                new AsyncTask<Void, Void, HelloGreetingCollection> () {
                    @Override
                    protected HelloGreetingCollection doInBackground(Void... unused) {

                        // Retrieve service handle using credential since this is an authenticated call.
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
                };
        getGreetingAndDisplay.execute((Void)null);
    }

    private void displayGreetings(HelloGreetingCollection... greetings) {
        Toast.makeText(HelloGreetingCollection, greetings, Toast.LENGTH_LONG).show();
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
}
