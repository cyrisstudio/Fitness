package com.fitness.fitness.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertAll(List<DataEntity> all);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(DataEntity data);

    @Query("SELECT * FROM DataEntity ORDER BY date DESC")
    List<DataEntity> getData();


    @Query("SELECT count(*) FROM DataEntity")
    int size();
}
