package com.example.justin.tester_adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridAdapter.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnCourseSelectedListener}
 * interface.
 */
public class CourseFragment extends Fragment {

    private static final String LOG_TAG = "CourseFragment";
    static String TESTDATA;
    private String testdata;

    Menu1 menu[] = Menu1.menu1;

    private AbsListView mListView;

    private CourseAdapter mAdapter;

    private OnCourseSelectedListener mListener;

    public interface OnCourseSelectedListener {
        void onCourseSelected();
    }

    public CourseFragment() {}

    public static CourseFragment newInstance(String testdata) {
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putString(TESTDATA, testdata);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnCourseSelectedListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        testdata = getArguments().getString(TESTDATA);
        Log.d(LOG_TAG, testdata);

        Context context = getActivity().getApplicationContext();
        mAdapter = new CourseAdapter(mListener, menu, inflater);

        View view = inflater.inflate(R.layout.course_layout, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);
        //mListView.setOnItemClickListener(ClickHandler);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private AdapterView.OnItemClickListener ClickHandler = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int course_selected, long id) {

            mListener.onCourseSelected();
        }
    };


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int course_selected, long id) {
//
//        mListener.onCourseSelected();
//    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

}
