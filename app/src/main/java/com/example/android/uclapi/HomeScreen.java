package com.example.android.uclapi;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity{

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        bottomNavBar();
        makeFragmentList();
        switchFragment(2, "Events");
    }

    private void makeFragmentList(){
        NewEvent newEvent = new NewEvent();
        Categories categories = new Categories();
        Events events = new Events();
        Tickets tickets = new Tickets();
        Timetable timetable = new Timetable();

        fragments.add(newEvent);
        fragments.add(categories);
        fragments.add(events);
        fragments.add(tickets);
        fragments.add(timetable);
    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, fragments.get(pos), tag)
                .commit();
    }

    public void bottomNavBar(){
        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.bottombar_events);
        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottombar_new:
                                //Toast.makeText(HomeScreen.this, "Clicked New Event", Toast.LENGTH_SHORT).show();
                                switchFragment(0, "New Event");
                                return true;
                            case R.id.bottombar_cat:
                                //Toast.makeText(HomeScreen.this, "Clicked Categories", Toast.LENGTH_SHORT).show();
                                switchFragment(1, "Categories");
                                return true;
                            case R.id.bottombar_events:
                                //Toast.makeText(HomeScreen.this, "Clicked Events", Toast.LENGTH_SHORT).show();
                                switchFragment(2, "Events");
                                return true;
                            case R.id.bottombar_tickets:
                                //Toast.makeText(HomeScreen.this, "Clicked Tickets", Toast.LENGTH_SHORT).show();
                                switchFragment(3, "Tickets");
                                return true;
                            case R.id.bottombar_timetable:
                                //Toast.makeText(HomeScreen.this, "Clicked Timetable", Toast.LENGTH_SHORT).show();
                                switchFragment(4, "Timetable");
                                return true;
                        }
                        return false;
                    }
                });

    }
}
