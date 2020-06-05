package org.yuri.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context){
        super(context, "Login db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table user(id text primary key, name text, password text, email text, gender text)");
//        db.execSQL("Create table user(id text primary key, name text, password text, email text, gender text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user");

    }

    //inserting in database
    public boolean insert(String id, String name, String password, String email, String gender){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("password",password);
        contentValues.put("email",email);
        contentValues.put("gender",gender);


        long ins = db.insert("user",null, contentValues);
        if(ins ==1) return false;
        else return true;
    }


    //checking if id exists;
    public Boolean chkid(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where id=?",new String[]{id});

        if(cursor.getCount()>0) return false;
        else return true;
    }

    //checking id and password;
    public Boolean idpassword(String id,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where id=? and password=?", new String[]{id,password});

        if(cursor.getCount()>0) return true;
        else return false;
    }





}
