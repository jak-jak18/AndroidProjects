package com.example.justin.cloud_example5;

/**
 * Created by Justin on 3/30/2015.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.oauth2.Oauth2;


public class MyApi {


        /**
         * Class instance of the JSON factory.
         */
        public static final JsonFactory JSON_FACTORY = new AndroidJsonFactory();

        /**
         * Class instance of the HTTP transport.
         */
        public static final HttpTransport HTTP_TRANSPORT = AndroidHttp.newCompatibleTransport();


        /**
         * Retrieves a Helloworld api service handle to access the API.
         */

    public static Oauth2 getApiServiceHandle() {
        // Use a builder to help formulate the API request.
        Oauth2.Builder helloWorld = new Oauth2.Builder(MyApi.HTTP_TRANSPORT,
                MyApi.JSON_FACTORY, null);

        return helloWorld.build();
    }

}
