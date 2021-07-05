package com.example.hospitalinformationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Hospital_Info extends AppCompatActivity {

    RecyclerView hosinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_info);

        hosinfo=findViewById(R.id.hoslist);

        Hospital[] hos=new Hospital[2];

        hos[0]=new Hospital(R.drawable.shalby,"Shelby Hospital","Naroda","10","2000 L","5");
        hos[1]=new Hospital(R.drawable.apollo,"Apollo Hospital","Sabarmati","8","3000 L","5");

        HospAdapter hospada=new HospAdapter();

        hospada.setItems(hos);
        hosinfo.setAdapter(hospada);
    }
}