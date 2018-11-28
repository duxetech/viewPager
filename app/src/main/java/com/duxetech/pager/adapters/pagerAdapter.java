package com.duxetech.pager.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karthik Swamy on 27-11-2018.
 */
public class pagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fList = new ArrayList<>();
    List<String> fTitle = new ArrayList<>();
    int no_tabs;

    public pagerAdapter(FragmentManager fm, int no_tabs) {
        super(fm);
        this.no_tabs = no_tabs;
    }

    @Override
    public Fragment getItem(int i) {
        return fList.get(i);
    }

    @Override
    public int getCount() {
        return fList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fTitle.get(position);
    }

    public void addFragment(Fragment f, String title){
        fList.add(f);
        fTitle.add(title);

    }
}
