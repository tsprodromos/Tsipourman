package com.example.tsipourman;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText email,username,password;
    Button btnregister;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.usernamelg);
        username=findViewById(R.id.passwordlg);
        password=findViewById(R.id.passwordrg);
        btnregister=findViewById(R.id.registerbtn);

        DB= new DBHelper(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail= email.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();

                 if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                     Toast.makeText(RegisterActivity.this,"All fiels Required", Toast.LENGTH_SHORT).show();
                 }else{
                     Boolean checkuser = DB.checkusername(user);
                     if(checkuser == false){
                         Boolean insert = DB.insertUser(mail,user,pass);
                         if(insert == true){
                             Toast.makeText(RegisterActivity.this,"Registered Successfully", Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                             startActivity(intent);
                         }else
                         {
                             Toast.makeText(RegisterActivity.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                         }
                     }else{
                         Toast.makeText(RegisterActivity.this,"User already Exists", Toast.LENGTH_SHORT).show();
                     }
                 }
            }
        });
    }
}