package com.fitness.fitness.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class DataEntity {

    @PrimaryKey(autoGenerate = true)
    int num;

    @ColumnInfo(name = "mPlanName")
    public String mPlanName;

    @ColumnInfo(name = "mWeek")
    public String mWeek;

    @ColumnInfo(name = "mDay")
    public int mDay;

    @ColumnInfo(name = "mExerciseCount")
    public int mExerciseCount;

    @ColumnInfo(name = "date")
    public Date date;

    @ColumnInfo(name = "mTiredness")
    public int mTiredness;

}
