package com.example.hospitalinformationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Request_Result extends AppCompatActivity {
    String date,name,type,status;
    RecyclerView reqview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_result);


        Intent intent=getIntent();
        date=intent.getStringExtra("date");
        name=intent.getStringExtra("pname");
        type=intent.getStringExtra("reqtype");
        status=intent.getStringExtra("status");


        Request req=new Request(date,name,type,status);

        reqview=findViewById(R.id.reqview);
        Request_Adapter reqAda =new Request_Adapter();
        reqAda.setItems(req);
        reqview.setAdapter(reqAda);

    }
}