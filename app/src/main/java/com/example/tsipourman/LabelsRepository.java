package com.example.tsipourman;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LabelsRepository {

    private  LabelsDao labelsDao;
    private LiveData<List<LabelEntity>> allLabels;

    public LabelsRepository(Application application){
        MyDatabase myDatabase = MyDatabase.getMyDatabase(application);
        labelsDao=myDatabase.labelsDao();
        allLabels = labelsDao.getAllLabels();
    }

    public void insert(LabelEntity labelEntity){
        new InsertLabelsAsyncTask(labelsDao).execute(labelEntity);

    }
    public void delete(LabelEntity labelEntity){
        new DeleteLabelsAsyncTask(labelsDao).execute(labelEntity);

    }
    public LiveData<List<LabelEntity>> getAllLabels(){
        return  allLabels;
    }

    private static class InsertLabelsAsyncTask extends AsyncTask<LabelEntity,Void,Void>{

        private LabelsDao labelsDao;

        private InsertLabelsAsyncTask(LabelsDao labelsDao){
            this.labelsDao=labelsDao;
        }

        @Override
        protected Void doInBackground(LabelEntity... labelEntities){
            labelsDao.insert(labelEntities[0]);
            return null;
        }
    }

    private static class DeleteLabelsAsyncTask extends AsyncTask<LabelEntity,Void,Void>{

        private LabelsDao labelsDao;

        private DeleteLabelsAsyncTask(LabelsDao labelsDao){
            this.labelsDao=labelsDao;
        }

        @Override
        protected Void doInBackground(LabelEntity... labelEntities){
            labelsDao.delete(labelEntities[0]);
            return null;
        }
    }
}
