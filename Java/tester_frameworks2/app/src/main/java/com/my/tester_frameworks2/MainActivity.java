package com.my.tester_frameworks2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.appspot.example_88523.backend.Backend;
import com.appspot.example_88523.backend.model.Frameworks2TextMessage;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Backend apiServiceHandle = AppConstants.getApiServiceHandle(null);
                            Frameworks2TextMessage response = new Frameworks2TextMessage();
                            try {
                                response = apiServiceHandle.sendMsg().execute();
                                Log.d(LOG_TAG, "Request Sent");
                            } catch (IOException e){
                                Log.e(LOG_TAG, "Exception during API call", e);
                            }

                            final String text = response.getText();
                            if (text == null){
                                Log.d(LOG_TAG, "No text returned");
                            }else {
                                final TextView textView = (TextView) findViewById(R.id.textview);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(text);
                                    }
                                });

                            }
                        }
                    }).start();

                } else {
                    Toast.makeText(MainActivity.this, "Please connect to Internet.", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        switch (id){
            case R.id.action_settings:
                final String address[] = getResources().getStringArray(R.array.servers);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Select Server")
                        .setItems(R.array.servers, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                AppConstants.setServer(address[which]);
                            }
                        });
                builder.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
