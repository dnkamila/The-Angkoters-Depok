package com.myangkot.templatetheangkoters;

/**
 * Created by user on 25/03/2015.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Angkot_Search extends Fragment {

    public Angkot_Search(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.drawer_list, container, false);

        return rootView;
    }
}
