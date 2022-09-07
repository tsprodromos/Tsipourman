package com.example.tsipourman;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tsipourman.databinding.ActivityMainBinding;

public class RegisterActivity extends AppCompatActivity {
    MyDatabase myDb;
    UserDao userDao;

    EditText email,username,password;
    Button registerbtn;
    public static boolean isAllowed=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        email=findViewById(R.id.myemail);
        username=findViewById(R.id.myusername);
        password=findViewById(R.id.mypassword);
        registerbtn=findViewById(R.id.registerbtn);



        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserEntity userEntity = new UserEntity();
                userEntity.setEmail(email.getText().toString());
                userEntity.setUsername(username.getText().toString());
                userEntity.setPassword(password.getText().toString());

                if (validateInput(userEntity)) {
                    //Insert Operation
                    MyDatabase myDatabase = MyDatabase.getMyDatabase(getApplicationContext());
                    final UserDao userDao = myDatabase.userDao();
                    if(userDao.username_is_taken(userEntity.getUsername())){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //Register User
                                userDao.insertUser(userEntity);
                                String name = userEntity.getUsername();
                                startActivity(new Intent(RegisterActivity.this,MainActivity.class).putExtra("name",name));
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "User Registered!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }).start();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity){
        if(userEntity.getUsername().isEmpty() || userEntity.getPassword().isEmpty() || userEntity.getEmail().isEmpty()){
                return false;
        }
        return true;
    }
}