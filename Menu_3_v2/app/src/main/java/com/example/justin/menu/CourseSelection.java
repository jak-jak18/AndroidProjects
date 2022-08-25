package com.example.justin.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

/**
 * Created by Justin on 6/4/2015.
 */
public class CourseSelection extends AppCompatActivity {

    //String address = "http://0.0.0.0:8080/_ah/img/WhBGhpJ3zia4xzq40b9mFw==";
    String address = "http://blogs.plos.org/obesitypanacea/files/2014/10/sandwich.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        new ImageFetch(this).execute(address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.menu);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.menu);
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

    public void startItemSelection(View v) {
        Intent intent = new Intent(CourseSelection.this, ItemSelection.class);
        startActivity(intent);
    }

}
