package com.karthik.pager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karthik Swamy on 27-11-2018.
 */
public class DBManager extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase db;
    String contacts_table = "contacts";
    String login_table = "login";
    Contacts contact;
    List<Contacts> contact_list;

    public DBManager(Context context) {
        super(context, "pager.db", null, '1');
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+contacts_table+"(first_name varchar, last_name varchar, phone int, mail varchar, address varchar)");
        db.execSQL("create table if not exists "+login_table+"(name varchar, password varchar, mail varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertContact(Contacts contact){
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("first_name",contact.getFirst_name());
        cv.put("last_name",contact.getLast_name());
        cv.put("phone",contact.getMobile());
        cv.put("mail",contact.getMail());
        cv.put("address",contact.getAddress());
        return db.insert(contacts_table,null,cv)!=1;

    }
    public List<Contacts> getAllContacts() {
        db = getReadableDatabase();
        Cursor c  = db.rawQuery("select * from "+contacts_table+"",null);
        contact_list = new ArrayList<>();
        while (c.moveToNext()){
            contact = new Contacts();
            contact.setFirst_name(c.getString(0));
            contact.setLast_name(c.getString(1));
            contact.setMobile(c.getString(2));
            contact.setMail(c.getString(3));
            contact.setAddress(c.getString(4));
            contact_list.add(contact);
        }
        return contact_list;
    }
    boolean checkPhoneExists(String phone) {
        db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from "+contacts_table+"", null);
        while (c.moveToNext()) {
            if (phone.equals(c.getString(c.getColumnIndex("phone")))) {

                return true;
            }
        }
        return false;
    }


}
