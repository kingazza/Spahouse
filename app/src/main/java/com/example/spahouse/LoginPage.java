package com.example.spahouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView username = (TextView) findViewById(R.id.usernameA);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbt =(MaterialButton) findViewById(R.id.loginbt);

        ///admin and admin

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admi")){
                    // correct password
                    Toast.makeText(LoginPage.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                }else
                    //incorrect password
                    Toast.makeText(LoginPage.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();


            }
        });


    }
}