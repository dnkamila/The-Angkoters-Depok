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
public class Setting extends Fragment {

    public Setting(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);

        return rootView;
    }
}
