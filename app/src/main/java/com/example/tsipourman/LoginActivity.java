package com.example.tsipourman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnlogin;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.usernamelg);
        password=findViewById(R.id.passwordlg);
        btnlogin=findViewById(R.id.loginbtn);


       session = new Session(this);

       if(session.loggedin()){
         startActivity(new Intent(LoginActivity.this,MainActivity.class));
          finish();
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String user=username.getText().toString();
                final String pass=password.getText().toString();
                if(user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all Fields", Toast.LENGTH_SHORT).show();
                } else{
                        MyDatabase myDatabase= MyDatabase.getMyDatabase(getApplicationContext());
                        UserDao userDao= myDatabase.userDao();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                UserEntity userEntity = userDao.login(user,pass);
                                if(userEntity == null){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }else {
                                    String name = userEntity.getUsername();
                                    startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("name",name));
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(), "Login Succesfully!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        }).start();
                    }
                }
        });

    }
}