package com.myangkot.templatetheangkoters;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Dion Geraldo on 3/28/2015.
 */
public class Favorites extends Fragment{

    public Favorites() {}
//        TextView faveName ;
//        TextView description;
//        public static final String MyPREFERENCES = "MyPrefs" ;
//        public static final String Name = "nameKey";
//        public static final String Desc = "phoneKey";
//
//
//        SharedPreferences sharedpreferences;
//        @Override
//        public void onCreate(Bundle savedInstanceState){
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.favorites_layout);
//
//            faveName = (TextView) findViewById(R.id.name);
//            description = (TextView) findViewById(R.id.desc);
//
//            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//
//            if (sharedpreferences.contains(Name)) {
//                faveName.setText(sharedpreferences.getString(Name, ""));
//
//            }
//            if (sharedpreferences.contains(Desc)) {
//                description.setText(sharedpreferences.getString(Desc, ""));
//
//            }
//        }
//
//    public void run(View view) {
//        String n = faveName.getText().toString();
//        String ph = description.getText().toString();
//        Editor editor = sharedpreferences.edit();
//        editor.putString(Name, n);
//        editor.putString(Desc, ph);
//        editor.commit();
//
//    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.favorites_layout, container, false);

        return rootView;
     }
}
