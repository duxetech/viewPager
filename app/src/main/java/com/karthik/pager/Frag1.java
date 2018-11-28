package com.karthik.pager;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.karthik.pager.MainActivity;

/**
 * Created by Karthik Swamy on 27-11-2018.
 */
public class Frag1 extends Fragment {
    TextView tvLogin;
    SharedPreferences pref;
    String data;
    EditText et_user, et_pass, et_mail;
    View view;
    DBManager db;
    Activity a;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.frag1, container, false);
        db = new DBManager(getActivity());
        a = getActivity();


        mapViews();
        et_user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                  //  Toast.makeText(getActivity(), "Enter Name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        et_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                   // Toast.makeText(getActivity(), "Enter Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return  view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }


    void mapViews(){
        et_user = view.findViewById(R.id.et3);
        et_pass = view.findViewById(R.id.et4);
    }
}
