package com.example.tsipourman;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version =  1)
public abstract class MyDatabase extends RoomDatabase {

    private static final String dbName = "mydb";
    private static MyDatabase myDatabase;

    public static synchronized MyDatabase getMyDatabase(Context context){

        if(myDatabase == null){
            myDatabase = Room.databaseBuilder(context, MyDatabase.class,dbName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return myDatabase;
    }

    public abstract UserDao userDao();

}
