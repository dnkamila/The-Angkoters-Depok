package com.myangkot.templatetheangkoters;

import android.app.Activity;
import android.widget.EditText;

/**
 * Created by Andis muhammad on 28/03/2015.
 */
public class Route {
    private String _start, _end;

    public Route (String start, String end) {
        _start = start;
        _end = end;
    }

    public String getStart(){
        return _start;
    }

    public String getEnd() {
        return _end;
    }

}
