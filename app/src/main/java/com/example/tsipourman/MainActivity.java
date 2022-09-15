package com.example.tsipourman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private LabelsViewModel labelsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView1 = findViewById(R.id.recycler_view);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        LabelsAdapter adapter = new LabelsAdapter();
        recyclerView1.setAdapter(adapter);

        labelsViewModel = new ViewModelProvider(this).get(LabelsViewModel.class);
        labelsViewModel.getAllLabels().observe(this, new Observer<List<LabelEntity>>() {
            @Override
            public void onChanged(List<LabelEntity> labels) {
                adapter.setLabels(labels);
            }
        });

    }
}