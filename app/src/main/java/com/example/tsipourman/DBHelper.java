package com.example.tsipourman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;


public class DBHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USERS";
    public static final String COLUMN_USERNAME_USER = "USERNAME_USER";
    public static final String COLUMN_PASSWORD_USER = "PASSWORD_USER";
    public static final String COLUMN_EMAIL_USER = "EMAIL_USER";
    public static final String COLUMN_ID = "ID";

    public static final String LABELS_TABLE = "LABELS";
    public static final String COLUMN_NAME_LABEL = "name";
    public static final String COLUMN_VOLUME_LABEL = "volume";
    public static final String COLUMN_PRICE_LABEL= "price";

    public static final String DBNAME="mydb.db";
    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USER_TABLE
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EMAIL_USER + " TEXT, "
                + COLUMN_USERNAME_USER + " TEXT, "
                + COLUMN_PASSWORD_USER + " TEXT)";

        String createTableStatement1 = "CREATE TABLE " + LABELS_TABLE
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_NAME_LABEL + " TEXT, "
                + COLUMN_VOLUME_LABEL + " TEXT, "
                + COLUMN_PRICE_LABEL + " TEXT)";

        db.execSQL(createTableStatement);
        db.execSQL(createTableStatement1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public Boolean insertUser(String email, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_EMAIL_USER,email);
        values.put(COLUMN_USERNAME_USER,username);
        values.put(COLUMN_PASSWORD_USER,password);

        long result = db.insert(USER_TABLE,null,values);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME_USER + " = ? " ;

        Cursor cursor = db.rawQuery(queryString, new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME_USER + " = ? " + " AND " +COLUMN_PASSWORD_USER + " = ? " ;

        Cursor cursor = db.rawQuery(queryString, new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

}