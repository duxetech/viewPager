package com.duxetech.pager.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.duxetech.pager.R;
import com.duxetech.pager.adapters.pagerAdapter;
import com.duxetech.pager.events.Events;
import com.duxetech.pager.events.eventBus;
import com.duxetech.pager.fragments.AddContact;
import com.duxetech.pager.fragments.Contacts;

public class MainActivity extends AppCompatActivity {

    pagerAdapter adapter;
    String tabSelected, tabSwiped;
    Bundle bundle;
    Fragment con;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager pager = findViewById(R.id.pager);
        TabLayout tab = findViewById(R.id.tabs);
        adapter = new pagerAdapter(getSupportFragmentManager(),tab.getTabCount());

        //adapter.addFragment(new Login(),"Login");
        con = new Contacts();
        con.setArguments(bundle);
        adapter.addFragment(new AddContact(),"Add Contact");
        adapter.addFragment(con,"Contacts");
       // adapter.addFragment(new Details(),"Details");
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));


        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Toast.makeText(MainActivity.this, ""+tab.getText(), Toast.LENGTH_SHORT).show();
                tabSwiped = String.valueOf(tab.getText());
                eventBus.getBus().post(new Events.TabSelected(tabSwiped));

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
