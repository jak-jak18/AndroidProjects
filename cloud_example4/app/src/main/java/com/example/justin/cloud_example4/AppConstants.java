package com.example.justin.cloud_example4;

/**
 * Created by Justin on 3/20/2015.
 */

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.appspot.example_88523.helloworld.Helloworld;
import com.example.justin.cloud_example4.Helloworld;

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
    public static Helloworld getApiServiceHandle() {
        // Use a builder to help formulate the API request.
        Helloworld.Builder helloWorld = new Helloworld.Builder(AppConstants.HTTP_TRANSPORT,
                AppConstants.JSON_FACTORY, null);

        return helloWorld.build();
    }

}
