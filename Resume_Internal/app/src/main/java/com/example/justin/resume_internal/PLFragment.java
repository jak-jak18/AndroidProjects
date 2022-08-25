package com.example.justin.resume_internal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 5/2/2016.
 */
public class PLFragment extends Fragment {

    private static final String LOG_TAG = "MainFragment";

    public PLFragment() {}

    public static PLFragment newInstance(Bundle args) {
        PLFragment fragment = new PLFragment();
        fragment.setArguments(args);
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
    Bundle args = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        args = getArguments();
        fragmentAdapter = new FragmentAdapter(subjects, inflater);

        return inflater.inflate(R.layout.programming_languages, container, false);
    }

    ListView itemList;
    TextView textView;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        textView = (TextView) view.findViewById(R.id.textView4);
        textView.setMovementMethod(new ScrollingMovementMethod());

        itemList = (ListView) view.findViewById(R.id.listView2);
        itemList.setAdapter(fragmentAdapter);
        itemList.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int selection, long id) {
                textView.setText(args.getString(subjects.get(selection).id));
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
