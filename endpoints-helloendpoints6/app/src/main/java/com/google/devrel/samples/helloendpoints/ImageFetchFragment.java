package com.google.devrel.samples.helloendpoints;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;

/**
 * Created by Justin on 9/9/2017.
 */

public class ImageFetchFragment extends Fragment {

    private static final String LOG_TAG = "ImageFetchFragment";

    public ImageFetchFragment() {}

    public static ImageFetchFragment newInstance(String[] addresses) {
        ImageFetchFragment fragment = new ImageFetchFragment();
        Bundle args = new Bundle();
        args.putStringArray("AddressCollection", addresses);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        new ImageFetch((LinearLayout) view.findViewById(R.id.test))
                .execute(getArguments().getStringArray("AddressCollection"));

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        return AnimationUtils.loadAnimation(getActivity(),
//                enter ? android.R.anim.fade_in : android.R.anim.fade_out);
//    }
}
