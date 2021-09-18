package com.example.hospitalinformationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class requestAcceptReject extends AppCompatActivity {
    RecyclerView req_list;
    RequestRes mydb;
    Request[] record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_accept_reject);

        mydb = new RequestRes(this);

        record = mydb.selectdataprofile();

        if (record == null) {
            Toasty.info(requestAcceptReject.this, "No record Found", Toast.LENGTH_SHORT).show();
        } else {
            for (Request req : record) {
                Log.d("date", req.getDate());
                Log.d("name", req.getPname());
                Log.d("reqtype", req.getReqtype());
                Log.d("status", req.getStatus());

            }


            RequestStatusAdapter rvadapter = new RequestStatusAdapter();
            rvadapter.setItems(record);
            req_list = findViewById(R.id.reqview);
            Log.d("Length", String.valueOf(rvadapter.getItemCount()));
            req_list.setAdapter(rvadapter);


        }
    }
}