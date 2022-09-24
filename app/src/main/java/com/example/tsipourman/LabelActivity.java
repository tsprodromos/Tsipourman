package com.example.tsipourman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class LabelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);

        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");
        String suggestion = getIntent().getStringExtra("suggestion");
        String price = getIntent().getStringExtra("price");
        String image = getIntent().getStringExtra("logo");
        Log.i("mimg",image +"");

        TextView lab_name = findViewById(R.id.name_lab);
        TextView lab_desc = findViewById(R.id.lab_desc_con);
        TextView lab_desc1 = findViewById(R.id.lab_desc);
        TextView lab_sug = findViewById(R.id.lab_sugg_con);
        TextView lab_sug1 = findViewById(R.id.lab_sugg);
        TextView lab_price1 = findViewById(R.id.lab_price);
        TextView lab_price = findViewById(R.id.lab_price_con);
        ImageView lab_img = findViewById(R.id.img_lab);
        Button add_lab = findViewById(R.id.add_btn);

        lab_name.setText(name);
        lab_desc.setText(desc);
        lab_sug.setText(suggestion);
        Picasso.get().load(image).into(lab_img);
        lab_price.setText(price);




    }
}