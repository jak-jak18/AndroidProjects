/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Justin.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.users.User;

import java.util.ArrayList;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(name = "cloudexample3",
        version = "v1",
        scopes = {Constants.EMAIL_SCOPE},
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class MyEndpoint {
    public static ArrayList<MyBean> greetings = new ArrayList<MyBean>();

    static {
        greetings.add(new MyBean("hello world!"));
        greetings.add(new MyBean("goodbye world!"));
    }

    public MyBean getGreeting(@Named("id") Integer id) throws NotFoundException {
        try {
            return greetings.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new NotFoundException("Greeting not found with an index: " + id);
        }
    }

    public ArrayList<MyBean> listGreeting() {
        return greetings;
    }

    @ApiMethod(name = "greetings.multiply", httpMethod = "post")
    public MyBean insertGreeting(@Named("times") Integer times, MyBean greeting) {
        MyBean response = new MyBean();
        StringBuilder responseBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            responseBuilder.append(greeting.getMessage());
        }
        response.setMessage(responseBuilder.toString());
        return response;
    }

    @ApiMethod(name = "greetings.authed", path = "hellogreeting/authed")
    public MyBean authedGreeting(User user) {
        MyBean response = new MyBean("hello " + user.getEmail());
        return response;
    }
}

