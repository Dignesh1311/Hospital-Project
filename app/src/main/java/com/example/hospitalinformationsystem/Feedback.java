package com.example.hospitalinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class Feedback extends AppCompatActivity {

    EditText name,email,mobile_number,feedback_write;
    Button feedback_submit_btn;
    ImageView toolbar_back;
    RatingBar feedback_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().hide();

        name = findViewById(R.id.feedback_name);
        email = findViewById(R.id.feedback_email);
        mobile_number = findViewById(R.id.feedback_number);
        feedback_write = findViewById(R.id.feedback_write);
        feedback_submit_btn = findViewById(R.id.feedback_submit_btn);
        feedback_rating = findViewById(R.id.feedback_rating);
        toolbar_back = findViewById(R.id.toolbar_back);

        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feedback.this,Home.class);
                startActivity(intent);
            }
        });
    }
}