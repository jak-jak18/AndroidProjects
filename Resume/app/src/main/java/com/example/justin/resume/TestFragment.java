package com.example.justin.resume;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 5/10/2016.
 */
public class TestFragment extends ListFragment{
    private static final String LOG_TAG = "TestFragment";

    public TestFragment() {}

    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    List<String> subjects = new ArrayList<String>();
    ArrayAdapter adapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        subjects.add("Programming Languages");
        subjects.add("Background Information");
        subjects.add("Contact");

//        int layout = android.R.layout.simple_list_item_1;
        int layout = R.layout.text_layout;
        adapter = new ArrayAdapter<String>(activity, layout, subjects);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(LOG_TAG, "Item selected");
    }
}
