package com.example.tester_cardview3;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter4 extends BaseAdapter {

    Context context;
    String[] titles;

    public ListViewAdapter4(Context context){
        this.context = context;
        this.titles = context.getResources().getStringArray(R.array.titles);
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
        String[] item;

        if(position == 0){
            item = context.getResources().getStringArray(R.array.item1);
        }else if(position == 1){
            item = context.getResources().getStringArray(R.array.item2);
        }else {
            item = context.getResources().getStringArray(R.array.item3);
        }

        final View container = LayoutInflater.from(context).inflate(R.layout.sample_card4, parent, false);
        TextView title = container.findViewById(R.id.title);
        title.setText(titles[position]);
        TextView name = container.findViewById(R.id.name);
        name.setText(item[0]);
        TextView description = container.findViewById(R.id.description);
        description.setText(item[1]);
        TextView price = container.findViewById(R.id.price);
        price.setText(item[2]);

        final ConstraintLayout content = container.findViewById(R.id.content);
        final ImageView indicator = container.findViewById(R.id.indicator);
        indicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content.getVisibility() == View.GONE){
                    indicator.setImageResource(R.drawable.baseline_expand_less_blue_36);
                    content.setVisibility(View.VISIBLE);
                }else {
                    indicator.setImageResource(R.drawable.baseline_expand_more_blue_36);
                    content.setVisibility(View.GONE);
                }
            }
        });

        convertView = container;

//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent,false);

        return convertView;
    }
}
