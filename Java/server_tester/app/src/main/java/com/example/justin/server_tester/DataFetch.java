package com.example.justin.server_tester;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.appspot.tastebudz.backend.Backend;
import com.appspot.tastebudz.backend.Backend.Menu.*;
import com.appspot.tastebudz.backend.model.TastebudzItem;
import com.appspot.tastebudz.backend.model.TastebudzMenuCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 5/12/2017.
 */

public class DataFetch extends AsyncTask<Pair<String, String>, Void, Object> {

    private static final String LOG_TAG = "DataFetch";

    private Activity activity;
    private ListView listView;
    private Boolean list_menu = false, menu_info = false;

    public DataFetch(Activity activity, ListView listView) {
        this.activity = activity;
        this.listView = listView;
    }

    @Override
    protected Object doInBackground(Pair<String,String>... params) {

        Backend apiServiceHandle = AppConstants.getApiServiceHandle(null);
        Object result = new Object();

        if ("List Menus".equals(params[0].first)){
            try {
                Log.d(LOG_TAG, params[0].first + " called");
                list_menu = true;
                ListMenu listMenuCommand = apiServiceHandle.menu().listMenu();

                result = listMenuCommand.execute();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }

        }else if("Get Menu Info".equals(params[0].first)){
            try {
                Log.d(LOG_TAG, params[0].first + " called");
                menu_info = true;
                GetMenuInfo getMenuInfoCommand = apiServiceHandle.menu().getMenuInfo(params[0].second);

                result = getMenuInfoCommand.execute();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }
        }else if("Get Menu".equals(params[0].first)){
            try {
                Log.d(LOG_TAG, params[0].first + " called");
                Backend.Menu.GetMenu getMenuCommand = apiServiceHandle.menu().getMenu(params[0].second);

                result = getMenuCommand.execute();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }

        }else if("Get Course".equals(params[0].first)){
            try {
                Log.d(LOG_TAG, params[0].first + " called");
                GetCourse getCourseCommand = apiServiceHandle.menu().getCourse("Test Menu",params[0].second);

                result = getCourseCommand.execute();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }

        }else if("Get Item".equals(params[0].first)){
            try {
                Log.d(LOG_TAG, params[0].first + " called");
                GetItem getItemCommand = apiServiceHandle.menu().getItem(params[0].second);

                result = getItemCommand.execute();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception during API call", e);
            }
        }

        return result;
    }

    TastebudzItem tastebudzItem;
    @Override
    protected void onPostExecute(Object object) {
        if (object!=null) {
            if (list_menu) {
                final TastebudzMenuCollection menuCollection = (TastebudzMenuCollection) object;
                String[] menu_names = menuCollection.getMenuNames().toArray(new String[]{});
                ArrayAdapter adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1);
                listView.setAdapter(adapter);
                adapter.addAll(menu_names);


                listView.setOnItemClickListener(new ListView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int selection, long id) {
                        Intent mapIntent = new Intent(activity, BasicMapDemoActivity.class);
                        List<Double> list_coord = menuCollection.getCoordinates();
//                        double[] coordiantes = {list_coord.get(2*selection), list_coord.get(2*selection+1)};
                        mapIntent.putExtra("Coordinates", new double[] {list_coord.get(2*selection), list_coord.get(2*selection+1)});
                        activity.startActivity(mapIntent);
                    }
                });

            }else if(menu_info){
                final TastebudzMenuCollection menuCollection = (TastebudzMenuCollection) object;
                ArrayAdapter adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1,
                        menuCollection.getPresentation().toArray(new String[] {}));
                listView.setAdapter(adapter);

            } else {
                tastebudzItem = (TastebudzItem) object;
                Context context = activity.getApplicationContext();
                LayoutInflater inflater = (LayoutInflater)context.getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                ListViewAdapter adapter = new ListViewAdapter("Get Menu", tastebudzItem, inflater);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new ListView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int selection, long id) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        builder.setCancelable(true);
                        builder.setTitle("Item Description")
                                .setItems(DialogData(selection), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {}
                                });
                        builder.show();
                    }
                });
            }

        } else {
            Log.e(LOG_TAG, "No menus were returned by the API.");
        }
    }

    private String[] DialogData(int position){
        List<String> list = new ArrayList<String>();
        list.add(tastebudzItem.getCourseName().get(position));
        list.add(tastebudzItem.getItemName().get(position));
        list.add(tastebudzItem.getDescription().get(position));
        list.add(tastebudzItem.getIngredients().get(position));

        return list.toArray(new String[]{});
    }

}
