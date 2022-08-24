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
    private static final String LOG_TAG = "CourseSelection";
    //String address = "http://0.0.0.0:8080/_ah/img/WhBGhpJ3zia4xzq40b9mFw==";
    String address = "http://blogs.plos.org/obesitypanacea/files/2014/10/sandwich.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_selection);
        getAndDisplayImage.execute(address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    AsyncTask<String, Void, Bitmap> getAndDisplayImage =
            new AsyncTask<String, Void, Bitmap> () {
                @Override
                protected Bitmap doInBackground(String... address) {
                    try {
                        URL url = new URL(address[0]);
                        HttpGet httpRequest = null;

                        httpRequest = new HttpGet(url.toURI());

                        HttpClient httpclient = new DefaultHttpClient();
                        HttpResponse response = (HttpResponse) httpclient.execute(httpRequest);

                        HttpEntity entity = response.getEntity();
                        BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
                        InputStream input = bufHttpEntity.getContent();

                        Bitmap image = BitmapFactory.decodeStream(input);

                        input.close();
                        return image;

                    } catch (MalformedURLException e) {
                        Log.e(LOG_TAG, "bad url", e);
                    } catch (Exception e) {
                        Log.e(LOG_TAG, "io error", e);
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Bitmap image) {
                    if (image!=null) {
                        ImageView view1 = (ImageView) findViewById(R.id.sandwich);
                        view1.setImageBitmap(image);
                    } else {
                        Log.e(LOG_TAG, "No images were returned :(");
                    }
                }
            };

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
