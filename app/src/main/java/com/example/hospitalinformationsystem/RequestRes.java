package com.example.hospitalinformationsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RequestRes extends SQLiteOpenHelper {

    public RequestRes(@Nullable Context context) {
        super(context,"Request.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table Requests(date Text ,name  Text primary key,reqtype Text,status Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists Requests");
    }

    public boolean cancelreq(Request req)
    {
        SQLiteDatabase db=getWritableDatabase();
        String[] reqid=new String[1];
        reqid[0]=req.getPname();

        return db.delete("Requests","name=?",reqid)!=0;
    }

    public boolean insertReq(String date, String name,String type,String status)
    {

        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date" ,date);
        contentValues.put("name" ,name );
        contentValues.put("reqtype" ,type);
        contentValues.put("status" ,status);

        long result = myDB.insert("Requests",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    Request[] selectdataprofile(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor result=sqLiteDatabase.rawQuery("select * from Requests",null);

        if(result.getCount()==0)
        {return null;}
        else
            {
            Request[] userlist = new Request[result.getCount()];
            int ctr=0;
            result.moveToFirst();
            while(!result.isAfterLast())
            {
                Request req=new Request();
                req.setDate(result.getString(result.getColumnIndex("date")));
                req.setPname(result.getString(result.getColumnIndex("name")));
                req.setReqtype(result.getString(result.getColumnIndex("reqtype")));
                req.setStatus(result.getString(result.getColumnIndex("status")));

                userlist[ctr++]=req;

                result.moveToNext();

            }

            return userlist;
        }
    }

}

