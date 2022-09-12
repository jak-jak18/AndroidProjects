package com.example.tester_cardview3;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;

public class ListViewAdapter extends BaseAdapter {

    Context context;

    public ListViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String[] titles = context.getResources().getStringArray(R.array.titles);
        String[] content = context.getResources().getStringArray(R.array.content);
        Pair<String, String> data = new Pair(titles[position], content[position]);

        convertView = LayoutInflater.from(context).inflate(R.layout.sample_card, parent, false);
        ExpandableListView expandableListView = convertView.findViewById(R.id.expandable);
        ExListAdapter2 exListAdapter = new ExListAdapter2(data, context);
        expandableListView.setAdapter(exListAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                return false;
            }
        });

//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent,false);

        return convertView;
    }
}
