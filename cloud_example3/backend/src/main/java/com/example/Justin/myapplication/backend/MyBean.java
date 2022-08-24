package com.example.Justin.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    public String message;

    public MyBean() {};

    public MyBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}