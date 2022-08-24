package com.example.tsipourman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USERNAME_USER = "USERNAME_USER";
    public static final String COLUMN_PASSWORD_USER = "PASSWORD_USER";
    public static final String COLUMN_EMAIL_USER = "EMAIL_USER";
    public static final String COLUMN_ID = "ID";
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

        db.execSQL(createTableStatement);
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
