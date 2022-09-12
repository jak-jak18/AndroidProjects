package com.example.justin.dynamicimageview_bundle;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Justin on 7/22/2015.
 */
class CourseAdapter extends BaseAdapter {
    Context context;
    int data[][];

    public CourseAdapter(Context context, int data[][], LayoutInflater inflater) {
        this.context = context;
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return Course2.data.length;
    }

    @Override
    public Course1 getItem(int position) {
        return Course1.COURSE1[position];
    }

    @Override
    public long getItemId(int position) {
        return Course2.data[0][position];
    }

    int i;
    int j;
    int layout = R.layout.course2;

    LayoutInflater inflater;
    View view;

    ImageView item;
    LinearLayout item_display;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        view = inflater.inflate(layout, parent, false);
        item_display = (LinearLayout) view.findViewById(R.id.item_display);
        //item_display.setDividerPadding(50);

        if (convertView == null) {
                for (i = 0; i < data[position].length; ++i) {
                    item = new ImageView(context);
                    item.setLayoutParams(new ViewGroup.LayoutParams(75,75));
                    item.setPadding(50,50,50,50);
                    item.setBackgroundResource(data[position][i]);
                    item_display.addView(item);
                }
            convertView = view;
        }
        //getImage(convertView, position);
        return convertView;
    }

}
