package com.example.justin.dynamicimageview_bundle;

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
import android.widget.TextView;

import com.example.justin.dynamicimageview_bundle.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridAdapter.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnCourseSelectedListener}
 * interface.
 */
public class CourseFragment extends Fragment implements AbsListView.OnItemClickListener {

    int i;

    private static final String LOG_TAG = "CourseFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    static String dataKey;
    String testdata;

    int data[][] = new Course2().getData();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AbsListView mListView;

    private CourseAdapter mAdapter;

    private OnCourseSelectedListener mListener;

    public interface OnCourseSelectedListener {
        void onCourseSelected(String course);
    }

    public CourseFragment() {}

    // TODO: Rename and change types of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        testdata = getArguments().getString(dataKey);
        Log.d(LOG_TAG, "Passed data from MainActivity to CourseFragment: " + testdata);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context context = getActivity().getApplicationContext();
        mAdapter = new CourseAdapter(context, data, inflater);

        View view = inflater.inflate(R.layout.course_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mListener.onCourseSelected(DummyContent.ITEMS.get(position).id);
        }
    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

}
