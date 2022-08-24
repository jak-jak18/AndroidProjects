package com.example.justin.tester;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Justin on 7/18/2015.
 */
public class CourseFactory {
    static private Context context;
    static View view;
    static ImageView item = new ImageView(context);

    static int i;
    static int j;
    static int individual_course = R.id.relative_layout;
    static int LAYOUT_DIRECTION_LTR;

    public CourseFactory(Context context){
        this.context = context;
    }

    public static LinearLayout CourseDisplay() {

        LinearLayout menu = (LinearLayout) view.findViewById(R.id.menu);
        RelativeLayout courses[] = new RelativeLayout[3];
        Button title = (Button) view.findViewById(R.id.title);
        HorizontalScrollView item_display = new HorizontalScrollView(context);
        item_display.setLayoutParams(new ViewGroup.LayoutParams(75,75));

        int id = Course1.COURSE1[i].image0;
        id = id - 0;
        item.setLayoutParams(new ViewGroup.LayoutParams(75,75));
        item.setPadding(46,0,0,15);

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
        return menu;
    }
}
