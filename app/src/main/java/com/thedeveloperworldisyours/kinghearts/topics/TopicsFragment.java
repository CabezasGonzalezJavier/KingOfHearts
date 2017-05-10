package com.thedeveloperworldisyours.kinghearts.topics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.kinghearts.R;

public class TopicsFragment extends Fragment implements TopicsContract.View{

    public TopicsFragment() {
        // Required empty public constructor
    }

    public static TopicsFragment newInstance() {
        return new TopicsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.topics_fragment, container, false);
    }

    @Override
    public void setPresenter(TopicsContract.Presenter presenter) {

    }
}
