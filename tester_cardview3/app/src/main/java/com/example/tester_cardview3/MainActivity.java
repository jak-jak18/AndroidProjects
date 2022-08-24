package com.example.tester_cardview3;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.listview_layout2);
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        ListView listView = findViewById(R.id.listview);
//        listView.setAdapter(new ListViewAdapter(getApplicationContext()));
//        listView.setAdapter(new ListViewAdapter2(this));
//        listView.setAdapter(new ListViewAdapter3(this));

        setContentView(R.layout.main_activity_layout);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
        String[] courses;

        public ViewPagerAdapter(FragmentManager fm){
            super(fm);
            courses = getResources().getStringArray(R.array.courses);
        }

        @Override
        public int getCount() {
            return courses.length;
        }

        @Override
        public Fragment getItem(int i) {
            return new CourseFragment();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return courses[position];
        }
    }

    public static class CourseFragment extends Fragment{

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.listview_layout,container,false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            ListView listView = view.findViewById(R.id.listview);
            listView.setAdapter(new ListViewAdapter4(getActivity()));
        }
    }
}
