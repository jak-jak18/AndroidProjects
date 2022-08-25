package com.example.justin.menu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Justin on 6/4/2015.
 */
public class CourseSelection extends AppCompatActivity {

    //String address = "http://0.0.0.0:8080/_ah/img/WhBGhpJ3zia4xzq40b9mFw==";
    String address = "http://blogs.plos.org/obesitypanacea/files/2014/10/sandwich.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_selection);
        new ImageFetch().execute(address);
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
        setContentView(R.layout.course_selection);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.course_selection);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.course_selection);
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
