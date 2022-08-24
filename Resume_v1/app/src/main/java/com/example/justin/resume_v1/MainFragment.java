package com.example.justin.resume_v1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 5/9/2016.
 */
public class MainFragment extends Fragment implements ListView.OnItemClickListener{

    public MainFragment() {}

    private static final String LOG_TAG = "MainFragment";

    private OnSubjectSelectedListener mListener;
    public interface OnSubjectSelectedListener {
        void onSubjectSelected(String subject);
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    List<String> subjects = new ArrayList<String>();
//    ArrayAdapter adapter;
    ListView itemList;
    MainFragmentAdapter MFadapter;

//    String subjects[]= {"Programming Languages", "Background Information", "Contact"};

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        subjects.add("Background Information");
        subjects.add("Programming Languages");
        subjects.add("Contact");

        try {
            mListener = (OnSubjectSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnBISelectedListener");
        }

//        int layout = android.R.layout.simple_list_item_1;
//        int layout = R.layout.text_layout;
//        adapter = new ArrayAdapter<String>(activity, layout, subjects);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MFadapter = new MainFragmentAdapter(subjects, inflater);
        view = inflater.inflate(R.layout.content_main_alt, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        itemList = (ListView) view.findViewById(R.id.listView);
        itemList.setAdapter(MFadapter);
        itemList.setOnItemClickListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    String subject;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int selection, long id) {

        subject = subjects.get(selection);
//        Log.d(LOG_TAG, subject + " selected");
        mListener.onSubjectSelected(subject);
    }
}
