package com.example.hospitalinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Case_Transfer extends AppCompatActivity {
    String tohos;
    TextView tohosp;
    EditText patname;
    Button transfer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_transfer);
        Intent extradata=getIntent();
        tohos=extradata.getStringExtra("Hospital Name");
        tohosp=findViewById(R.id.tohos);
        tohosp.setText(tohos);
        patname=findViewById(R.id.pname);
        transfer=findViewById(R.id.case_btn);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String currentDateandTime = sdf.format(new Date());
                Intent intent=new Intent(Case_Transfer.this,Request_Result.class);
                intent.putExtra("date",currentDateandTime);
                intent.putExtra("pname",patname.getText().toString());
                intent.putExtra("reqtype","Case Transfer");
                intent.putExtra("status","Pending");
                startActivity(intent);
            }
        });
    }
}