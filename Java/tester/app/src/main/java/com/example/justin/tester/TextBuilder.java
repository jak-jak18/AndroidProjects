package com.example.justin.tester;

/**
 * Created by Justin on 7/18/2015.
 */
public class TextBuilder {

    static StringBuilder sb = new StringBuilder();

    public static String TextBuilder() {

        String slow = "Magic Carpet";
        String ride = " Ride";
        String text = sb.append(slow).append(ride).toString();
        return text;
    }

}
