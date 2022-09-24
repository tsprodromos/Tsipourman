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

    public List<LabelEntity> mlabels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView1 = findViewById(R.id.recycler_view);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        LabelsAdapter adapter = new LabelsAdapter(this,mlabels,this);
        recyclerView1.setAdapter(adapter);

        labelsViewModel = new ViewModelProvider(this).get(LabelsViewModel.class);
        labelsViewModel.getAllLabels().observe(this, new Observer<List<LabelEntity>>() {
            @Override
            public void onChanged(List<LabelEntity> labels) {
                adapter.setLabels(labels);
                Log.i("MyTag0",adapter +"");

                Log.i("MyTag1",labels +"");
                mlabels = labels;
                Log.i("MyTag2",mlabels +"");

            }
        });

        Log.i("MyTag3",mlabels +"");
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,LabelActivity.class);
        intent.putExtra("name",mlabels.get(position).name);
        intent.putExtra("desc",mlabels.get(position).description);
        intent.putExtra("suggestion",mlabels.get(position).suggestion);
        intent.putExtra("logo",mlabels.get(position).logo);
        intent.putExtra("price",mlabels.get(position).price);

        startActivity(intent);
    }
}