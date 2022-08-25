package com.example.justin.server_tester;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appspot.tastebudz.backend.model.TastebudzItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 5/12/2017.
 */

class ListViewAdapter extends BaseAdapter {

    private static final String LOG_TAG = "ListViewAdapter";

    private String command;
    private TastebudzItem tastebudzItem;
    private LayoutInflater inflater;

    ListViewAdapter(String command, TastebudzItem tastebudzItem, LayoutInflater inflater){
        this.command = command;
        this.tastebudzItem = tastebudzItem;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {return tastebudzItem.getItemName().size();}

    @Override
    public String getItem(int position) {
        return tastebudzItem.getItemName().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        textView.setText(getItem(position));
        textView.setTextColor(0xff000000);
//        Log.d(LOG_TAG, getItem(position));
        return view;
    }
}
