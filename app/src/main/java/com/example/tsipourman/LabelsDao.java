package com.example.tsipourman;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LabelsDao {

    @Insert
    void insert(LabelEntity labels);

    @Delete
    void delete(LabelEntity labels);

    @Query("Select * from labels ORDER BY name ASC")
    LiveData<List<LabelEntity>> getAllLabels();

}
