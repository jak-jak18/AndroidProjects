package com.example.justin.resume_v1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Justin on 5/2/2016.
 */
public class BIFragment extends Fragment {
    private static final String LOG_TAG = "BI Fragment";

    String text;
    public BIFragment() {}

    public static BIFragment newInstance() {
        BIFragment fragment = new BIFragment();
        return fragment;
    }

    Pair<String, String> pair = new Pair<String, String>("BI", "data");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(LOG_TAG, "Data returned: " + text);

        return inflater.inflate(R.layout.background_information, container, false);
    }

    TextView textView;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        textView = (TextView) view.findViewById(R.id.textView4);
        new DataFetch(textView).execute(pair);

    }
}
