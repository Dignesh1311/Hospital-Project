package com.example.hospitalinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends AppCompatActivity {

    EditText name,email,mobile,password,confirmpassword;
    ImageView imageView;
    Button register_btn;
    TextView login_textview;
    UserDb myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imageView = findViewById(R.id.register_image);
        name = findViewById(R.id.register_name);
        email = findViewById(R.id.register_email);
        mobile = findViewById(R.id.register_mobilenumber);
        password = findViewById(R.id.register_password);
        confirmpassword = findViewById(R.id.register_ConfirmPaaword);
        register_btn = findViewById(R.id.register_btn);
        login_textview = findViewById(R.id.login_textview);
        getSupportActionBar().hide();

        myDB = new UserDb(this);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String email1 = email.getText().toString();
                String mobile1 = mobile.getText().toString();
                String password1 = password.getText().toString();
                String confirmpassword1 = confirmpassword.getText().toString();

                if (name1.equals("") || email1.equals("") ||mobile1.equals("") || password1.equals("") || confirmpassword1.equals("")){
                    Toast.makeText(Register.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password1.equals(confirmpassword1)){
                        Boolean checkuser = myDB.checkemail(email1);
                        if (checkuser == false){
                            Boolean result = myDB.insertuser(name1,email1,mobile1,password1);
                            if (result == true){
                                Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this,Login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Register.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Register.this, "Password did not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




        login_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });


    }
}