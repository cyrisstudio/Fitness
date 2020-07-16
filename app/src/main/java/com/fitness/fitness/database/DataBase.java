package com.fitness.fitness.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(entities = {DataEntity.class}, version = 1,exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class DataBase extends RoomDatabase {

    private static final String DatabaseName = "TopScoreDatabase";
    private static  DataBase sInstance;

    public static  DataBase getInstance(Context context)
    {

        if(sInstance==null)
        {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),DataBase.class,DataBase.DatabaseName).build();
        }
        return sInstance;
    }
    public abstract DataDao daoInterface();

}
