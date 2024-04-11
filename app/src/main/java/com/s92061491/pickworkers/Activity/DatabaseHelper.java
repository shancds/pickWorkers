package com.s92061491.pickworkers.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String databaseName = "pickWorker.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "pickWorker.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table allusers(username TEXT ,email TEXT primary key,phonenumber TEXT,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists allusers");

    }

    public Boolean insertUserData(String userName, String email, String phoneNumber, String password){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",userName);
        contentValues.put("email",email);
        contentValues.put("phonenumber",phoneNumber);
        contentValues.put("password",password);
        long result = myDatabase.insert("allusers",null,contentValues);

        if( result == -1){
            return false;
        }else {
            return true;
        }
    }
    public Boolean checkUserEmail(String email){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("select * from allusers where email=?",new String[]{email});
        if (cursor.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkUserEmailPassword(String email,String password){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("select * from allusers where email=? and password=?",new String[]{email, password});

        if(cursor.getCount() > 0){
            return true;
        }else {
            return false;
        }

    }
}
