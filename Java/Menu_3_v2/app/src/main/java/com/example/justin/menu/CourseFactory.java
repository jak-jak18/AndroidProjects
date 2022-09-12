package com.example.justin.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Rylan on 7/8/2015.
 */
public class CourseFactory {

    View view;
    LinearLayout menu = (LinearLayout) view.findViewById(R.id.menu);
    Button title = (Button) view.findViewById(R.id.title);
    HorizontalScrollView item_display;

    ImageView item;
    RelativeLayout courses[] = new RelativeLayout[3];

    int i;
    int j;
    int individual_course = R.id.relative_layout;

    public void CourseDisplay() {
        int id = Course1.COURSE1[i].image0;
        id = id - 0;
        item.setLayoutParams(new ViewGroup.LayoutParams(75,75));

        for (i = 0; i < Course1.COURSE1.length; ++i){
            courses[i] = (RelativeLayout) courses[i].findViewById(individual_course);

            //Set course title
            title.setText(Course1.COURSE1[i].course);
            courses[i].addView(title);

            item_display = (HorizontalScrollView) view.findViewById(R.id.item_display);

            //Set item display
            for (j= 0; j < Course1.COURSE1.length; ++j){
                id= id + j;
                item.setImageResource(id);
                item_display.addView(item);
                id= id - j;
            }

            //Add items display to individual_course
            courses[i].addView(item_display);

            //Add course to menu
            menu.addView(courses[i]);
        }

    }
}
