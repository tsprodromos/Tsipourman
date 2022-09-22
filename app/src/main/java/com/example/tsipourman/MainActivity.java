package com.example.tsipourman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements RecyclerViewInterface{
    private LabelsViewModel labelsViewModel;

    private List<LabelEntity> labels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView1 = findViewById(R.id.recycler_view);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        LabelsAdapter adapter = new LabelsAdapter(this,labels,this);
        recyclerView1.setAdapter(adapter);

        labelsViewModel = new ViewModelProvider(this).get(LabelsViewModel.class);
        labelsViewModel.getAllLabels().observe(this, new Observer<List<LabelEntity>>() {
            @Override
            public void onChanged(List<LabelEntity> labels) {
                adapter.setLabels(labels);
            }
        });

        Log.i("MyTag",labels +"");
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,LabelActivity.class);
        intent.putExtra("name",labels.get(position).name);
        intent.putExtra("desc",labels.get(position).description);
        intent.putExtra("suggestion",labels.get(position).suggestion);
        intent.putExtra("logo",labels.get(position).logo);
        intent.putExtra("price",labels.get(position).price);

        startActivity(intent);
    }
}