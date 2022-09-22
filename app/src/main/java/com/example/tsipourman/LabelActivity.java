package com.example.tsipourman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LabelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);

        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");
        String suggestion = getIntent().getStringExtra("suggestion");
        String price = getIntent().getStringExtra("price");

        int image = getIntent().getIntExtra("logo",0);

        TextView lab_name = findViewById(R.id.name_lab);
        TextView lab_desc = findViewById(R.id.lab_desc);
        TextView lab_sug = findViewById(R.id.lab_sugg);
        TextView lab_price = findViewById(R.id.lab_price);
        ImageView lab_img = findViewById(R.id.img_lab);
        Button add_lab = findViewById(R.id.add_btn);

        lab_name.setText(name);
        lab_desc.setText(desc);
        lab_sug.setText(suggestion);
        lab_img.setImageResource(image);
        lab_price.setText(price);




    }
}