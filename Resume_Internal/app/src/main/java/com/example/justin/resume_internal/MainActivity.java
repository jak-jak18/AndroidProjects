package com.example.justin.resume_internal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        MainFragment.OnSubjectSelectedListener  {

    private static final String LOG_TAG = "MainActivity";

    private static final String ANDROID = "android";
    private static final String PYTHON = "python";
    private static final String GAE = "gae";
    private static final String HTML5 = "html5";
    private static final String BI = "bi";

    Bundle args = new Bundle();
    String pl[], bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pl = getResources().getStringArray(R.array.programming_languages);

        args.putString(ANDROID, pl[0]);
        args.putString(PYTHON, pl[1]);
        args.putString(GAE, pl[2]);
        args.putString(HTML5, pl[3]);

        bi = getResources().getString(R.string.background_information);

        args.putString(BI, bi);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onStart(){
        super.onStart();

        MainFragment fragment = new MainFragment().newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    Fragment fragment;
    String selection;

    public void onSubjectSelected(String subject) {

        if (subject == "Background Information") {
            fragment = new BIFragment().newInstance(args);
            selection = "BI_selected";

        } else if (subject == "Programming Languages") {
            fragment = new PLFragment().newInstance(args);
            selection = "PL_selected";

        } else if (subject == "Contact") {
            fragment = new Contact().newInstance();
            selection = "Contact";
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(selection)
                .commit();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            fragment = new MainFragment().newInstance();
            selection = "Home_selected";

        } else if (id == R.id.background_information) {
            fragment = new BIFragment().newInstance(args);
            selection = "BI_selected";

        } else if (id == R.id.programming_languages) {
            fragment = new PLFragment().newInstance(args);
            selection = "PL_selected";

        } else if (id == R.id.contact) {
            fragment = new Contact().newInstance();
            selection = "Contact";
        }

        getSupportFragmentManager()
                .popBackStack();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(selection)
                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
