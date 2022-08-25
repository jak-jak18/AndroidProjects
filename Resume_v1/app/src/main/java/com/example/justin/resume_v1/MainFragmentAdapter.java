package com.example.justin.resume_v1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 7/22/2015.
 */
class MainFragmentAdapter extends BaseAdapter {

    private static final String LOG_TAG = "MainFragmentAdapter";

    List<String> subjects;
    LayoutInflater inflater;

    public MainFragmentAdapter(List<String> subjects, LayoutInflater inflater) {
        this.subjects = subjects;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return subjects.size();
    }

    @Override
    public String getItem(int position) {
        return subjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return subjects.size();
    }

    int layout = R.layout.text_layout;

    View view;
    TextView name;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        view = inflater.inflate(layout, parent, false);

        if (convertView == null) {
            name = (TextView) view.findViewById(R.id.text_layout);
            name.setText(getItem(position));
//            view.setId(getItem(position).hashCode());
//            name.setOnClickListener(this);

            convertView = view;
        }
        return convertView;
    }

//    @Override
//    public void onClick(View v) {
//        Log.d(LOG_TAG, "Position of item clicked: " + v.getId());
//    }

}
