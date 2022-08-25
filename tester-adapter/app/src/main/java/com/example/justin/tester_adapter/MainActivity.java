package com.example.justin.tester_adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Justin on 12/7/2015.
 */
public class MainActivity extends FragmentActivity implements CourseFragment.OnCourseSelectedListener {
    private static final String LOG_TAG = "MainActivity";
    static String testdata = "Fragment 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_container);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            CourseFragment courseFragment = new CourseFragment().newInstance(testdata);
//            Bundle args = new Bundle();
//            args.putString(CourseFragment.TESTDATA, testdata);
//            courseFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, courseFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCourseSelected() {
        testdata = "Fragment 2";
        CourseFragment courseFragment = new CourseFragment().newInstance(testdata);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.course_layout, courseFragment)
                .addToBackStack("course_selected")
                .commit();

    }
}