package com.example.justin.resume_internal;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Justin on 7/15/2016.
 */
public class SQLFragment extends Fragment {

    public SQLFragment() {}

    public static SQLFragment newInstance() {
        SQLFragment fragment = new SQLFragment();
        return fragment;
    }

    DbHelper mDbHelper;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();
        mDbHelper = new DbHelper(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.sql_layout, container, false);
    }

    EditText first, middle, last;
    Button enter_data, display_data;
    Pair<String, String> pair;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        first = (EditText) view.findViewById(R.id.editText);
        middle = (EditText) view.findViewById(R.id.editText2);
        last = (EditText) view.findViewById(R.id.editText3);

        enter_data = (Button) view.findViewById(R.id.button);
        enter_data.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Input(first, middle, last);
            }
        });

        display_data = (Button) view.findViewById(R.id.button2);
        display_data.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Read();
            }
        });
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return AnimationUtils.loadAnimation(getActivity(),
                enter ? android.R.anim.fade_in : android.R.anim.fade_out);
    }

    SQLiteDatabase db;
    ContentValues values = new ContentValues();
    String first_name, middle_name, last_name;
    long newRowId;

    public void Input(EditText first, EditText middle, EditText last){
        db = mDbHelper.getWritableDatabase();

        first_name = first.getText().toString();
        middle_name = middle.getText().toString();
        last_name = last.getText().toString();

        values.put(FRC.FeedEntry.FIRST_NAME, first_name);
        values.put(FRC.FeedEntry.MIDDLE_NAME, middle_name);
        values.put(FRC.FeedEntry.LAST_NAME, last_name);

        newRowId = db.insert(
                FRC.FeedEntry.TABLE_NAME,
                FRC.FeedEntry.COLUMN_NAME_NULLABLE,
                values);
        showMessage(newRowId);
    }

    public void showMessage(Long result){
        if (result == -1){
            Toast.makeText(context, "Data input failed. :(", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Data input succes. Row id: "+ result, Toast.LENGTH_SHORT).show();
        }
    }

    public void Read(){
        db = mDbHelper.getReadableDatabase();

        String[] projection = {
                FRC.FeedEntry._ID,
                FRC.FeedEntry.FIRST_NAME,
                FRC.FeedEntry.MIDDLE_NAME,
                FRC.FeedEntry.LAST_NAME
        };

        String name = "bob";
        String selection = FRC.FeedEntry.FIRST_NAME + " LIKE ?";
        String[] selectionArgs = {name};

        String sortOrder =
                FRC.FeedEntry._ID + " ASC";

        Cursor c = db.query(
                FRC.FeedEntry.TABLE_NAME,                 // The table to query
                projection,                               // The columns to return
                selection,                                     // The columns for the WHERE clause
                selectionArgs,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                // The sort order
        );

        if(c.getCount() == 0){
            showMessage("No data returned.", "No data returned.");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        while(c.moveToNext()){
            buffer.append("ID: " + c.getString(0) + "\n");
            buffer.append("First Name: " + c.getString(1) + "\n");
            buffer.append("Middle Name: " + c.getString(2) + "\n");
            buffer.append("Last Name: " + c.getString(3) + "\n");
        }

//        Toast.makeText(context, buffer.toString(), Toast.LENGTH_SHORT).show();

        showMessage("Data", buffer.toString());
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
