package com.example.justin.tester;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by Justin on 7/29/2015.
 */
public class CourseFragment extends Fragment {


    public CourseFragment(){

    }
    /**
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mAdapter = new MeatAdapter(inflater, R.layout.item_meat_grid);
        return inflater.inflate(R.layout.fragment_fragment_transition, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listview);
        courseAdapter = new CourseAdapter(MainActivity.this);
        listView.setAdapter(courseAdapter);
    }*/
}
