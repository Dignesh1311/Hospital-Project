package com.example.hospitalinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BedRequest extends AppCompatActivity {

    Button req;
    EditText pname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_request);

        req=findViewById(R.id.req_btn);
        pname=findViewById(R.id.pname);


        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String currentDateandTime = sdf.format(new Date());
                Intent intent=new Intent(BedRequest.this,Request_Result.class);
                intent.putExtra("date",currentDateandTime);
                intent.putExtra("pname",pname.getText().toString());
                intent.putExtra("reqtype","Bed Request");
                intent.putExtra("status","Pending");
                startActivity(intent);
            }
        });

    }
}