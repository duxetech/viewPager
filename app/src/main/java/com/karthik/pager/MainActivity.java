package com.karthik.pager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    pagerAdapter adapter;
    String tabSelected, tabChanged;
    String cat;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager pager = findViewById(R.id.pager);
        TabLayout tab = findViewById(R.id.tabs);
        adapter = new pagerAdapter(getSupportFragmentManager(),tab.getTabCount());

        adapter.addFragment(new Frag1(),"Login");
        adapter.addFragment(new Frag2(),"Add Contact");
        adapter.addFragment(new Frag3(),"Contacts");
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        bundle = new Bundle();
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {


            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               // Toast.makeText(MainActivity.this, ""+tab.getText(), Toast.LENGTH_SHORT).show();
               tabSelected = String.valueOf(tab.getText());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                 Toast.makeText(MainActivity.this, ""+tab.getText(), Toast.LENGTH_SHORT).show();
                tabChanged = String.valueOf(tab.getText());
                bundle.putString("tabSwiped",tabChanged);
                Frag2 fragobj = new Frag2();
                fragobj.setArguments(bundle);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}