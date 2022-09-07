package com.example.tsipourman;


import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao  {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserEntity userEntity);

    @Query("SELECT * from users where username=:userName")
    boolean username_is_taken(String userName);

    @Query("SELECT * from users where username=:userName AND password=:password")
    UserEntity login(String userName,String password);

}
