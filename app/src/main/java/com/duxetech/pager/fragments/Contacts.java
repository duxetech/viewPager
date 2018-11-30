package com.duxetech.pager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.duxetech.pager.adapters.CustAdapter;
import com.duxetech.pager.db.DBManager;
import com.duxetech.pager.R;
import com.duxetech.pager.events.Events;
import com.duxetech.pager.events.eventBus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import static com.duxetech.pager.events.eventBus.getBus;

/**
 * Created by Karthik Swamy on 27-11-2018.
 */
public class Contacts extends Fragment {

    ListView lv;
    CustAdapter adapter;
    List<com.duxetech.pager.model.Contacts> list = new ArrayList<>();
    Bundle b = new Bundle();
    DBManager db;
    View v;
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
        v= inflater.inflate(R.layout.frag3, container, false);
        initialize();
        return v;
    }

    void initialize(){
        db = new DBManager(getActivity());
        list = db.getAllContacts();
        b= getArguments();
        lv = v.findViewById(R.id.lv);
        adapter = new CustAdapter(getActivity(),list);
        lv.setAdapter(adapter);
    }

}
