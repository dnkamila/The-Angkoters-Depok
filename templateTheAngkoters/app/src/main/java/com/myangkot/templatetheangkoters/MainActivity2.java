package com.myangkot.templatetheangkoters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity2 extends ActionBarActivity {

    String TITLES[] = {"Angkot Search","Nearby Angkot","Favorites","Angkot Details","Angkot News", "Setting","User Guide","Feedback Us","About Us"};
    int ICONS[] = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};

    String NAME = "The Angkoters Depok";
    int PROFILE = R.drawable.ic_launcher;

    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view

    private Toolbar toolbar;                              // Declaring the Toolbar Object
    // RecyclerView mRecyclerView;                           // Declaring RecyclerView
    ListView mListView;
    ListAdapter mAdapter;
    // RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    // RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;                                  // Declaring DrawerLayout
    ActionBarDrawerToggle mDrawerToggle;
    public CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_template);
        getIntent();
        setContentView(R.layout.drawer_list);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Angkot Search");

//        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
//        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
//        mAdapter = new MyAdapter(TITLES,ICONS,NAME,PROFILE);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
//
//        // And passing the titles,icons,header view name, header view email,
//        // and header view profile picture
//        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
//        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        mRecyclerView.addOnItemTouchListener(
//                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override public void onItemClick(View view, int position) {
//                        Toast.makeText(getApplicationContext(),
//                                "Data : " + TITLES[position],
//                                Toast.LENGTH_SHORT).show();
//                    }
//                })
//        );

        mListView = (ListView) findViewById(R.id.list_slidermenu);
        mAdapter = new ListAdapter(getApplicationContext(),TITLES,ICONS,NAME,PROFILE);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new SlideMenuClickListener());

        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

    }

    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                break;
            case 1:
                fragment = new Angkot_Search();
                break;
            case 2:
                fragment = new Nearby_Angkot();
                break;
            case 3:
                fragment = new Favorites();
                break;
//            case 4:
//                fragment = new PagesFragment();
//                break;
//            case 5:
//                fragment = new WhatsHotFragment();
//                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container , fragment).commit();

            // update selected item and title, then close the drawer
            mListView.setItemChecked(position, true);
            mListView.setSelection(position);
            setTitle(TITLES[position-1]);
            Drawer.closeDrawer(mListView);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_template, menu);
        return true;
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
