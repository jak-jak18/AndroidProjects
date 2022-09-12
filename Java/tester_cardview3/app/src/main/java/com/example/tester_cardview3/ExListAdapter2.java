package com.example.tester_cardview3;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExListAdapter2 extends BaseExpandableListAdapter {

    String title;
    String content;
    Context context;

    public ExListAdapter2(Pair<String, String> inp, Context context){
        this.title = inp.first;
        this.content = inp.second;
        this.context = context;
    }

//    Group Methods

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return title;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        convertView = LayoutInflater
                .from(context)
                .inflate(R.layout.header_layout, parent, false);
        if(isExpanded){
            ImageView indicator = convertView.findViewById(R.id.indicator);
            indicator.setImageResource(R.drawable.baseline_expand_less_black_36);
        }
        TextView textView = convertView.findViewById(R.id.title);
        textView.setText(title);
        return convertView;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

//    Child Methods


    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return content;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater
                .from(context)
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(content);
        return convertView;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
