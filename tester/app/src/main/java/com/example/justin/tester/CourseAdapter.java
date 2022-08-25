package com.example.justin.tester;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Justin on 7/22/2015.
 */
class CourseAdapter extends BaseAdapter {
    private Context context;
    LayoutInflater inflater;

    public CourseAdapter(Context context, LayoutInflater inflater) {
        this.context = context;
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

    int idImageView = R.id.item;
    int mResourceId = R.layout.course2;
    int data [][] = new Course2().getData();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = inflater.inflate(mResourceId, parent, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

            for (int i = 0; i < 1; ++i) {
                imageView.setBackgroundResource(data[position][i]);
            }

            convertView = view;
        }
        return convertView;
    }

    /**
     int numtable[][] = {
     {R.mipmap.salad,2,3},
     {R.mipmap.soup,5,6},
     {R.mipmap.sandwich,8,9},
     };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null){
            view = inflater.inflate(mResourceId, parent, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

            for (int i= 0; i< 1; ++i) {
                imageView.setBackgroundResource(numtable[position][i]);
            }

            convertView = view;
        }
        return convertView;
    }*/

    /**
     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
     final View view = new View(context);
     TextView text = (TextView) view.findViewById(R.id.TextView);
     return text;
     }*/

    /**
    int numtable[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
    };
    StringBuilder sb = new StringBuilder();


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        String text;

        if (convertView == null){
            view = inflater.inflate(mResourceId, parent, false);
            TextView textView = (TextView) view.findViewById(R.id.course2);

            for (int i= 0; i< numtable.length; ++i) {
                sb = sb.append(numtable[position][i]);
            }

            text= sb.toString();
            textView.setText(text);
            sb.delete(0, numtable.length);

            convertView = view;
        }
        //convertView.setBackgroundResource(R.mipmap.soup);
        getImage(convertView, position);
        return convertView;
    }

    public void getImage(View convertView, int position) {
        Course1 image = getItem(position);
        convertView.setBackgroundResource(image.image0);
    }
    */

    /**
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null){
            view = inflater.inflate(mResourceId, parent, false);
            view.setBackgroundResource(R.mipmap.soup);
            convertView = view;
        }
        //convertView.setBackgroundResource(R.mipmap.soup);
        getImage(convertView, position);
        return convertView;
    }

    public void getImage(View convertView, int position) {
        Course1 image = getItem(position);
        convertView.setBackgroundResource(image.image0);
    }
    */
}
