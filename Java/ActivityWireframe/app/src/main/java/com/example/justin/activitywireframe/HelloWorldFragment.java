package com.example.justin.activitywireframe;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Justin on 6/18/2017.
 */

public class HelloWorldFragment extends Fragment {
    private static final String LOG_TAG = "HelloWorldFragment";

    public static HelloWorldFragment newInstance() {
        return new HelloWorldFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.hello_world, container, false);
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return AnimationUtils.loadAnimation(getActivity(),
                enter ? android.R.anim.fade_in : android.R.anim.slide_out_right);
    }

}
