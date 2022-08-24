package com.example.justin.tester_fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
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
 * Created by Justin on 7/4/2015.
 */
public class ImageFetch extends AsyncTask<String, Void, Bitmap> {
    private static final String LOG_TAG = "ImageFetch";
    Context context;

    /*
    public ImageFetch(Context context){
        this.context = context;
    }*/

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
        } else {
            Log.e(LOG_TAG, "No images were returned :(");
        }
    }
}
