package com.example.myre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "Shopping.db";
    public final static String TABLE_NAME="SignUp";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+TABLE_NAME+"(FirstName text,LastName text,Email text PRIMARY KEY,Password text,CPassword text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+TABLE_NAME);
    }
    //inserting in database
    public boolean insert(String FirstName,String LastName,String Email,String Password,String CPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FirstName",FirstName);
        contentValues.put("LastName",LastName);
        contentValues.put("Email",Email);
        contentValues.put("Password",Password);
        contentValues.put("CPassword",CPassword);
        long ins = db.insert(TABLE_NAME,"null",contentValues);
        if(ins == -1) return false;
        else return true;
    }

    //Checking Email and Password
    public Boolean validate(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE email=? AND password=?",new String[] {email});
        if(cursor.getCount()>0) return true;
        else    return  false;
    }
}
