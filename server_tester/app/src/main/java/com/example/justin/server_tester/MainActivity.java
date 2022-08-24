package com.example.justin.server_tester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.appspot.tastebudz.backend.Backend;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.server_commands, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //TODO: Provide getter/setter for AppConstants
        AppConstants.setBase("1.15");
    }

    @Override
    public void onStart(){
        super.onStart();

    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //outState.putInt(ARG_POSITION, mCurrentPosition);
    }

    public void onClickGetData(View view) {
        View rootView = view.getRootView();
        TextView textView = (TextView) rootView.findViewById(R.id.editText);
        String input = textView.getText().toString();
        Spinner spin = (Spinner) rootView.findViewById(R.id.spinner);
        String selection = (String) spin.getSelectedItem();
//        Log.d(LOG_TAG, "Spinner value: " + selection + " " + selection.getClass().getSimpleName());
        Pair<String, String> pair = new Pair<String, String>(selection, input);
        new DataFetch(this, (ListView) findViewById(R.id.listView)).execute(pair);
    }



}
