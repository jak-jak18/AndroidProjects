package com.example.justin.resume;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 5/2/2016.
 */
public class PLFragment extends Fragment {

    private static final String LOG_TAG = "MainFragment";

    private static final String ANDROID = "android";
    private static final String PYTHON = "python";
    private static final String GAE = "gae";
    private static final String HTML5 = "html5";

    public PLFragment() {}

    static Bundle args;

    public static PLFragment newInstance(Bundle pArgs) {
        args = pArgs;
        PLFragment fragment = new PLFragment();
        return fragment;
    }

    List<Topics> subjects = new ArrayList<Topics>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        subjects.add(new Topics("Android/Java", "android"));
        subjects.add(new Topics("Python/REST API", "python"));
        subjects.add(new Topics("GAE/NoSQL", "gae"));
        subjects.add(new Topics("HTML5/CSS/JavaScript", "html5"));

        super.onCreate(savedInstanceState);
    }

    FragmentAdapter fragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (args.isEmpty()) {
            args.putString(ANDROID, null);
            args.putString(PYTHON, null);
            args.putString(GAE, null);
            args.putString(HTML5, null);

            Log.d(LOG_TAG, "Data added to bundle.");
        }

        fragmentAdapter = new FragmentAdapter(subjects, inflater);

        return inflater.inflate(R.layout.programming_languages, container, false);
    }

    ListView itemList;
    Pair<String, String> pair;
    TextView textView;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        textView = (TextView) view.findViewById(R.id.textView4);

        itemList = (ListView) view.findViewById(R.id.listView2);
        itemList.setAdapter(fragmentAdapter);
        itemList.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int selection, long id) {

                if(args.getString(subjects.get(selection).id) == null){
                    pair = new Pair<String, String>("PL", subjects.get(selection).id);
//                    pair = new Pair<String, String>("PL", "data 2");

                    new DataFetch(args, subjects.get(selection).id, textView).execute(pair);
                    Toast.makeText(getContext(), "Retrieving Data", Toast.LENGTH_SHORT).show();

                }else {
                    textView.setText(args.getString(subjects.get(selection).id));
                }
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return AnimationUtils.loadAnimation(getActivity(),
                enter ? android.R.anim.fade_in : android.R.anim.fade_out);
    }
}
