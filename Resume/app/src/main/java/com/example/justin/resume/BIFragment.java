package com.example.justin.resume;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

/**
 * Created by Justin on 5/2/2016.
 */
public class BIFragment extends Fragment {

    public BIFragment() {}

    public static BIFragment newInstance() {
        BIFragment fragment = new BIFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConnectivityManager connMgr = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

        } else {
            Toast.makeText(getContext(), "Please connect to Internet.", Toast.LENGTH_SHORT).show();
        }

        return inflater.inflate(R.layout.background_information_v2, container, false);
    }

    Pair<String, String> pair;
    TextView textView;
    Bundle args= new Bundle();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        textView = (TextView) view.findViewById(R.id.textView5);

        pair = new Pair<String, String>("BI", "data");
        new DataFetch(args, "data", textView).execute(pair);

        Toast.makeText(getContext(), "Retrieving Data", Toast.LENGTH_SHORT).show();
    }



    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return AnimationUtils.loadAnimation(getActivity(),
                enter ? android.R.anim.fade_in : android.R.anim.fade_out);
    }

}
