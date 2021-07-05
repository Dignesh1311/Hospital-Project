package com.example.hospitalinformationsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class UserDb extends SQLiteOpenHelper {


    public UserDb(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(name Text primary key, email Text, mobile Text, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists users");
    }

    public Boolean insertuser (String name, String email,String mobile,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , name);
        contentValues.put("email" , email);
        contentValues.put("mobile" , mobile);
        contentValues.put("password" , password);

        long result = myDB.insert("users",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkemail(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where email = ?", new String[]{email});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkemailpassword(String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where email = ? and password = ?", new String[]{email,password});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    Cursor selectdataprofile(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor result=sqLiteDatabase.rawQuery("select * from users",null);
        return result;
    }
}





