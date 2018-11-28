package com.karthik.pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Karthik Swamy on 28-11-2018.
 */
public class CustAdapter extends BaseAdapter {
    List<Contacts> list;
    Context context;
    TextView tv1, tv2, tv3,tv4;
    Contacts contact;

    public CustAdapter(Context context, List<Contacts> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inf.inflate(R.layout.listview_item,parent,false);
        tv1 = view.findViewById(R.id.tv1);
        tv3 = view.findViewById(R.id.tv3);
        contact = list.get(position);
        tv1.setText(contact.getFirst_name());
        tv3.setText(contact.getMobile());
        return view;
    }
}
