package com.example.tsipourman;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LabelsViewModel extends AndroidViewModel {

    private LabelsRepository repository;
    private LiveData<List<LabelEntity>> allLabels;
    public LabelsViewModel(@NonNull Application application) {
        super(application);
        repository = new LabelsRepository(application);
        allLabels = repository.getAllLabels();
    }

    public void insert(LabelEntity labelEntity){
        repository.insert(labelEntity);
    }

    public void delete(LabelEntity labelEntity){
        repository.delete(labelEntity);
    }

    public LiveData<List<LabelEntity>> getAllLabels(){
        return allLabels;
    }
}
