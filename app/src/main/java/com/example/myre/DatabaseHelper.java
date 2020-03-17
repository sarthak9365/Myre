package com.example.myre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Shopping.db";
    public static final String TABLE_NAME="signup";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS signup(_id INTEGER PRIMARY KEY AUTOINCREMENT, firstName TEXT, lastName TEXT, password TEXT, mobileNumber TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
    //Inserting data in database
    public long insert(String firstname, String lastname, String password, String mobilenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName",firstname);
        contentValues.put("lastName",lastname);
        contentValues.put("password",password);
        contentValues.put("mobileNumber",mobilenumber);
        long ins;
        ins = db.insert(TABLE_NAME,"null",contentValues);
        return ins;

    }

    public Cursor displayData(){
        SQLiteDatabase mydb=this.getReadableDatabase();
        Cursor resultCursor = mydb.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return resultCursor;
    }

    //Checking Email and Password
    public Boolean validate(String mobile,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String myquery = "SELECT * FROM "+TABLE_NAME+" WHERE mobilenumber=? AND password=?";
        System.out.println(myquery);
        Cursor cursor = db.rawQuery(myquery,new String[] {mobile,password}) ;
        if(cursor.getCount()>0) return true;
        else    return  false;
    }
}
