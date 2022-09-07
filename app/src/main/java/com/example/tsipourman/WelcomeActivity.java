package com.example.tsipourman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class WelcomeActivity extends AppCompatActivity {

    Button registerbtn,loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.welcome_activity);
        super.onCreate(savedInstanceState);
        registerbtn=findViewById(R.id.registerbtn);
        loginbtn=findViewById(R.id.loginbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(login_intent);
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent = new Intent(WelcomeActivity.this,RegisterActivity.class);
                startActivity(register_intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(WelcomeActivity.this,InfoActivity.class);
                startActivity(info);
            }
        });

    }
}
