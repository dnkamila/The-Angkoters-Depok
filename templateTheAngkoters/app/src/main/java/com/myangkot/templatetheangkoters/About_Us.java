package com.myangkot.templatetheangkoters;

/**
 * Created by user on 28/03/2015.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 28/03/2015.
 */
public class About_Us extends Fragment {

    public About_Us(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about_us, container, false);

        return rootView;
    }
}
