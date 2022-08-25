package com.example.justin.menu;

import android.app.Fragment;

/**
 * Created by Rylan on 6/27/2015.
 */
public class CourseFragments extends Fragment {
    int i;
    int j;

    StringBuilder sb = new StringBuilder();
    String base = "R.id.fragment";

    public void adder(){

        for( i=0; i<5; ++i){
            sb.append(base).append(i);
        }

    }



}
