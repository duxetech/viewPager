package com.karthik.pager;

import android.content.Intent;
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

import java.util.List;

/**
 * Created by Karthik Swamy on 27-11-2018.
 */
public class Frag2 extends Fragment {
    View view;
    DBManager db;
    EditText et_fName, et_lName, et_Mobile, et_mail, et_address;
    Button btn_addContact;
    List<Contacts> list ;
    String a, b,c,d,e;
    Contacts con;
    TextView tvWelcome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag2, container, false);

        db = new DBManager(getActivity());
        list = db.getAllContacts();
        mapViews();
        Bundle bundle = this.getArguments();
//        Toast.makeText(getActivity(), "hi "+bundle.getString("tabSwiped"), Toast.LENGTH_SHORT).show();

        btn_addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapInput();
                checkInputFields();
                if(a.equals("")|b.equals("")|c.equals("")){
                    Toast.makeText(getActivity(), "Enter all the details", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(db.checkPhoneExists(c)){
                    Toast.makeText(getActivity(), "Mobile no already exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                db.insertContact(new Contacts(a,b,c,d,e));
                // db.read(list);

                Intent i = new Intent(getActivity(),Frag3.class);
              //  startActivity(i);
                clear();
            }
        });



        return view;
    }

    void mapViews(){
        btn_addContact = view.findViewById(R.id.btn_addContact);
        et_fName = view.findViewById(R.id.et_fName);
        et_lName = view.findViewById(R.id.et_lName);
        et_Mobile = view.findViewById(R.id.et_Mobile);
        et_mail = view.findViewById(R.id.et_mail);
        et_address = view.findViewById(R.id.et_address);
    }
    void mapInput(){
        a = et_fName.getText().toString().trim();
        b = et_lName.getText().toString().trim();
        c = et_Mobile.getText().toString().trim();
        d = et_mail.getText().toString().trim();
        e = et_address.getText().toString().trim();

    }
    void checkInputFields(){

        if(checkA()|checkB()|checkC()){
            return;
        }
    }
    void checkUserExists(){


    }
    boolean checkA() {
        if (a.isEmpty()) {
            et_fName.setError("Field can't be empty");
            return false;
        } else
            return true;
    }

    boolean checkB() {
        if (b.isEmpty()) {
            et_lName.setError("Field can't be empty");
            return false;
        } else
            return true;
    }
    boolean checkC() {
        if (c.isEmpty()) {
            et_Mobile.setError("Field can't be empty");
            return false;
        } else
            return true;
    }

    void clear(){
        et_fName.setText("");
        et_lName.setText("");
        et_Mobile.setText("");
        et_mail.setText("");
        et_address.setText("");

    }
}
