package com.example.justin.tester_fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Justin on 7/22/2015.
 */
class CourseAdapter extends BaseAdapter {
    private Context context;
    Bitmap imageCollection[];
    LayoutInflater inflater;

    int id = R.mipmap.soup;

    public CourseAdapter(Context context, Bitmap imageCollection[], LayoutInflater inflater) {
        this.context = context;
        this.imageCollection = imageCollection;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return Course1.COURSE1.length;
    }

    @Override
    public Course1 getItem(int position) {
        return Course1.COURSE1[position];
    }

    @Override
    public long getItemId(int position) {
        return Course1.COURSE1[position].image0;
    }

    /**
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = new View(context);
        TextView text = (TextView) view.findViewById(R.id.TextView);
        return text;
    }*/

    ImageView item;
    long holder;
    int layout = R.layout.course2;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view;
        ImageView imageView;

        if (convertView == null){
            //item.setLayoutParams(new ViewGroup.LayoutParams(75,75));
            //item.setPadding(46,0,0,15);
            view = inflater.inflate(layout, parent, false);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageBitmap(imageCollection[position]);
            convertView = view;
        }
        //getImage(convertView, position);
        return convertView;
    }

    /**
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int id = Course1.COURSE1[position].image0;
        id = id -0;

        if (convertView == null){
            item.setLayoutParams(new ViewGroup.LayoutParams(75,75));
            item.setPadding(46,0,0,15);

            for (int i = 0; i < Course1.COURSE1.length; ++i){
                id=id+i;
                item.setImageResource(id);
                course.addView(item);
                id=id-i;
            }
            convertView = course;
        }
        //getImage(convertView, position);
        return convertView;
    }*/

    /**
    public void getImage(View convertView, int position) {
        Course1 image = getItem(position);
        convertView.setBackgroundResource(image.image0);
    }
     */
}
