package com.duxetech.pager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.duxetech.pager.adapters.CustAdapter;
import com.duxetech.pager.db.DBManager;
import com.duxetech.pager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karthik Swamy on 27-11-2018.
 */
public class Contacts extends Fragment {

    ListView lv;
    CustAdapter adapter;
    List<com.duxetech.pager.model.Contacts> list = new ArrayList<>();
    //List<String> list1 = new ArrayList<>(asList("aa","bb","cc"));
    DBManager db;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.frag3, container, false);
        db = new DBManager(getActivity());
        list = db.getAllContacts();

        lv = v.findViewById(R.id.lv);
        adapter = new CustAdapter(getActivity(),list);
        lv.setAdapter(adapter);
        return v;
    }

}
