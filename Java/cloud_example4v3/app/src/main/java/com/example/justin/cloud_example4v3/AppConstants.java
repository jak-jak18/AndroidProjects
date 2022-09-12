package com.example.justin.cloud_example4v3;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;


public class AppConstants {

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
    public static Tester getApiServiceHandle() {
        // Use a builder to help formulate the API request.
        Tester.Builder helloWorld = new Tester.Builder(AppConstants.HTTP_TRANSPORT,
                AppConstants.JSON_FACTORY, null).setRootUrl("http://192.168.1.100:8080/_ah/api/");

        return helloWorld.build();
    }

}