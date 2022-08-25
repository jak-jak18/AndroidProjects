package com.example.tester_cardview3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExListAdapter extends BaseExpandableListAdapter {

    HashMap<String, String> data;
    List<String> keys = new ArrayList<>();
    Context context;

    public ExListAdapter(HashMap<String, String> arg0, Context arg1){
        this.data = arg0;
        keys.addAll(arg0.keySet());
        context = arg1;
    }

//    Group Methods

    @Override
    public int getGroupCount() {
        return data.keySet().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return keys.get(groupPosition);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.header_layout, parent);
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
        return data.get(keys.get(groupPosition));
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
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
