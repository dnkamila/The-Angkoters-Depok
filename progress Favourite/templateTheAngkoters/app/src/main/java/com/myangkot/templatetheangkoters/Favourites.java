package com.myangkot.templatetheangkoters;

/**
 * Created by user on 25/03/2015.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Favourites extends Fragment {

    public Favourites(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);

        return rootView;
    }
}
