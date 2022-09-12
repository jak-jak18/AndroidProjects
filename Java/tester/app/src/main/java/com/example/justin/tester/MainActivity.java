package com.example.justin.tester;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**String base = "R.mipmap.pick";
    int id = R.mipmap.pick1;
     */
    LayoutInflater inflater;
    private CourseAdapter courseAdapter;
    int postion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = getLayoutInflater();

        ListView listView = (ListView) findViewById(R.id.listview);
        courseAdapter = new CourseAdapter(MainActivity.this, inflater);
        listView.setAdapter(courseAdapter);


        /**
        ImageView imageView = new ImageView(this);
        StringBuilder sb = new StringBuilder();

        id=id-1;
        RelativeLayout main_activity = (RelativeLayout) findViewById(R.id.main_activity);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(50, 50));

        for (int i =1; i < 2; ++i){
            //int id= Integer.parseInt((sb.append(base).append(i).toString()), 32);
            id=id+1;
            imageView.setImageResource(id);
        }

        main_activity.addView(imageView);
         */
        //new CourseFactory();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
    @Override
    protected void onStart() {
        super.onStart();

        int i;
        int j;
        int individual_course = R.id.relative_layout;

        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
        RelativeLayout courses[] = new RelativeLayout[3];
        Button title = (Button) findViewById(R.id.title);
        ImageView item = new ImageView(this);
        HorizontalScrollView item_display;

        item.setLayoutParams(new ViewGroup.LayoutParams(75,75));

        for (i = 0; i < Course1.COURSE1.length; ++i){
            courses[i] = (RelativeLayout) findViewById(individual_course);
            int id = Course1.COURSE1[i].image0;
            id = id - 0;

            //Set course title
            title.setText(Course1.COURSE1[i].course);
            courses[i].addView(title);

            item_display = (HorizontalScrollView) findViewById(R.id.item_display);

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
        setContentView(menu);
    }
     */

    /**
    @Override
    protected void onStart() {
        super.onStart();
        postion = 0;
        Course1 mCourse = courseAdapter.getItem(postion);
        String text = mCourse.course;
        TextView textView = (TextView) findViewById(R.id.TextView);
        textView.setText(text);
    }*/


    /**
    @Override
    protected void onStart() {
        super.onStart();
        String text = Course1.COURSE1[1].course;
        TextView textView = (TextView) findViewById(R.id.TextView);
        textView.setText(text);
    }*/

    /**
    protected void onStart() {
        super.onStart();
        LinearLayout menu = CourseFactory.CourseDisplay();
        setContentView(menu);
    }
     */

    /**
    @Override
    protected void onStart() {
        super.onStart();
        String text = TextBuilder.TextBuilder();
        TextView textView = (TextView) findViewById(R.id.TextView);
        textView.setText(text);
    }
    */

    /**
    public void setText(View view){
        super.setText();
        String text = TextBuilder.TextBuilder();
        TextView textView = (TextView) findViewById(R.id.TextView);
        textView.setText(text);
    }
     */
}
