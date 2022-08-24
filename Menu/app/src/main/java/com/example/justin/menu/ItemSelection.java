package com.example.justin.menu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.appspot.menu.menuitems.Menuitems;
import com.appspot.menu.menuitems.model.MenuDescriptionCollection;

import java.io.IOException;

/**
 * Created by Justin on 6/4/2015.
 */
public class ItemSelection extends AppCompatActivity {
    //String text = "Feels like the First Time";
    private static final String LOG_TAG = "ItemSelection";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_selection);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.item_selection);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.item_selection);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.item_selection);

        AsyncTask<Void, Void, MenuDescriptionCollection> getAndDisplayGreeting =
                new AsyncTask<Void, Void, MenuDescriptionCollection> () {
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
                            TextView text1 = (TextView) findViewById(R.id.sandwich_description);
                            text1.setText(text);
                        } else {
                            Log.e(LOG_TAG, "No greetings were returned by the API.");
                        }
                    }
                };

        getAndDisplayGreeting.execute((Void)null);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
