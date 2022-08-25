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
        new DescriptionFetch().execute();
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
