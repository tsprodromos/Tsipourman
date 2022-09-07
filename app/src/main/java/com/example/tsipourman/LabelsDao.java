package com.example.tsipourman;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LabelsDao {
    @Query("Select * from labels")
    List<LabelEntity> getAllLabels();

}
