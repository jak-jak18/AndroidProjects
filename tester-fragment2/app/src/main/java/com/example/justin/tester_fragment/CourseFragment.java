package com.example.justin.tester_fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.justin.tester_fragment.dummy.DummyContent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnCourseSelectedListener}
 * interface.
 */
public class CourseFragment extends Fragment implements AbsListView.OnItemClickListener {

    int i;

    private static final String LOG_TAG = "CourseFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Bitmap image;
    private Bitmap imageCollection [] = new Bitmap[3];

    String address0 = "http://images.nitrosell.com/product_images/6/1339/whitefish_bakedsalmon_salad.jpg";
    String address1 = "http://blogs.plos.org/obesitypanacea/files/2014/10/sandwich.jpg";
    String address2 = "http://cdn.swide.com/binaries/content/gallery/legacy/2011/4/23/colors/inside/colors_inside_01.jpg";
    String addressCollection [] = {address0, address1, address2};

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnCourseSelectedListener mListener;

    private AbsListView mListView;

    private CourseAdapter mAdapter;

    public CourseFragment() {
    }

    public interface OnCourseSelectedListener {
        // TODO: Update argument type and name
         void onCourseSelected(String course);
    }

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (i =0; i < addressCollection.length; i++) {
            try {
                image = new ImageFetch().execute(addressCollection[i]).get();
                imageCollection[i]= image;
            } catch (CancellationException e) {
                Log.e(LOG_TAG, "Task Cancelled!!!", e);
            } catch (ExecutionException e) {
                Log.e(LOG_TAG, "Somethin happened here", e);
            } catch (InterruptedException e) {
                Log.e(LOG_TAG, "Got interrupeted", e);
            }
        }

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAdapter = new CourseAdapter(getActivity(), imageCollection, inflater);

        View view = inflater.inflate(R.layout.fragment_item, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnCourseSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
