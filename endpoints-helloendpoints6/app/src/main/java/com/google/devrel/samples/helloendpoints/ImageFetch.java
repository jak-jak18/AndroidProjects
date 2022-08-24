package com.google.devrel.samples.helloendpoints;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 7/4/2015.
 */

public class ImageFetch extends AsyncTask<String[], Void, List<Bitmap>> {

    private static final String LOG_TAG = "ImageFetch";
    LinearLayout linearLayout;


    public ImageFetch(LinearLayout linearLayout){
        this.linearLayout = linearLayout;
    }

    List<Bitmap> images = new ArrayList<Bitmap>();
    @Override
    protected List<Bitmap> doInBackground(String[]... addresses) {
        for(String address: addresses[0]){
            try {
                Log.d(LOG_TAG, address);
                Bitmap image = BitmapFactory.decodeStream((InputStream)new URL(address).getContent());
                images.add(image);

            } catch (MalformedURLException e) {
                Log.e(LOG_TAG, "bad url", e);
            } catch (Exception e) {
                Log.e(LOG_TAG, "io error", e);
            }
        }

        return images;
    }

    @Override
    protected void onPostExecute(List<Bitmap> images) {
        for(Bitmap image: images){
            if (image!=null) {
                ImageView imageView = new ImageView(linearLayout.getContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(250,250));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5, 0, 10, 0);
                imageView.setImageBitmap(image);

                linearLayout.addView(imageView);
            } else {
                Log.d(LOG_TAG, "No images were returned :(");
            }
        }

        try {
            String test_uri = "https://storage.googleapis.com/images-88523/Water.jpg";
            Bitmap image = BitmapFactory.decodeStream((InputStream)new URL(test_uri).getContent());
            images.add(image);

            ImageView imageView = new ImageView(linearLayout.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(250,250));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 0, 10, 0);
            imageView.setImageBitmap(image);

            linearLayout.addView(imageView);

        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "bad url", e);
        } catch (Exception e) {
            Log.e(LOG_TAG, "io error", e);
        }
    }
}
