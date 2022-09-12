package com.example.justin.tester_adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Justin on 7/22/2015.
 */
class CourseAdapter extends BaseAdapter implements View.OnClickListener{

    Menu1 menu[];
    private static final String LOG_TAG = "CourseAdapter";
    private CourseFragment.OnCourseSelectedListener mListener;

    public CourseAdapter(CourseFragment.OnCourseSelectedListener mListener, Menu1 menu[], LayoutInflater inflater) {
        this.mListener = mListener;
        this.menu = menu;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return menu.length;
    }

    @Override
    public String getItem(int position) {
        return menu[position].course;
    }

    @Override
    public long getItemId(int position) {
        return menu.length;
    }

    int layout = R.layout.course;
    //int layout = R.layout.textview_course;

    LayoutInflater inflater;
    View view;

    TextView name;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        view = inflater.inflate(layout, parent, false);

        if (convertView == null) {
            //Log.d(LOG_TAG, "Value of postion: " + position);
            //name = (TextView) view.findViewById(R.id.textview_course);
            name = (TextView) view.findViewById(R.id.textView);
            name.setText(getItem(position));
            name.setId(position);
            name.setOnClickListener(this);

            convertView = view;
        }
        return convertView;
    }

    @Override
    public void onClick(View v) {
        Log.d(LOG_TAG, "Position of item clicked: " + v.getId());
        mListener.onCourseSelected();
    }

}
