package com.example.myre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Shopping.db";
    public static final String TABLE_NAME="sign_up";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS sign_up(_id INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, EMAILID TEXT, PASSWORD TEXT, CONFIRMPASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
    //Inserting data in database
    public long insert(String firstname,String lastname,String email,String password,String confirmpass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FIRSTNAME",firstname);
        contentValues.put("LASTNAME",lastname);
        contentValues.put("EMAILID",email);
        contentValues.put("PASSWORD",password);
        contentValues.put("CONFIRMPASSWORD",confirmpass);
        long ins = db.insert(TABLE_NAME,"null",contentValues);
        return ins;
    }

    public Cursor displayData(){
        SQLiteDatabase mydb=this.getReadableDatabase();
        Cursor resultCursor = mydb.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return resultCursor;
    }

    //Checking Email and Password
    public Boolean validate(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE EMAILID=email AND PASSWORD=password",new String[] {null});
        if(cursor.getCount()>0) return true;
        else    return  false;
    }
}
