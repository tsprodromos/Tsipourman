package com.example.tsipourman;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

@Database(entities = {UserEntity.class,LabelEntity.class}, version =  2)
public abstract class MyDatabase extends RoomDatabase {

    private static final String dbName = "mydb";

    private static MyDatabase myDatabase;

    private static Context activity;
    public static LabelsDao labelsDao;

    public abstract UserDao userDao();
    public abstract LabelsDao labelsDao();


    public static synchronized MyDatabase getMyDatabase(Context context){

        activity = context.getApplicationContext();

        if(myDatabase == null){
            myDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class,"dbName")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return myDatabase;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(myDatabase).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private LabelsDao labelsDao;
        private PopulateDbAsyncTask(MyDatabase db){
            labelsDao= db.labelsDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
//            labelsDao.insert(new LabelEntity(1,
//                    "γργγργ",
//                    "Απόσταγμα στέμφυλων (τσίκουδα) και Παλαιωμένο απόσταγμα από το υπόσκαφο οινοποιείο του Κωνσταντάκη (Kostantakis Milos Cave Winery) στα έγκατα της ηφαιστειογενούς Μήλου.", "Παξιμάδι με κάνναβη.\n Γραβιέρα premium με 4 πιπέρια.",
//                    "330ml",
//                    "https://imageproxy.wolt.com/menu/menu-images/615329284e88f5797fb4167c/7056382c-20fd-11ec-9f07-8e926c1a41c3_product__56_.jpeg"));
            //fillWithStartingData(activity);

            JSONArray labels = loadJSONArray(activity.getApplicationContext());

            try{

                for(int i = 0; i < labels.length(); i++){
                    JSONObject label = labels.getJSONObject(i);

                    String labelName= label.getString("name");
                    String labelDesc= label.getString("description");
                    String labelSuggestion= label.getString("suggestion");
                    String labelPrice= label.getString("price");
                    String labelLogo=label.getString("logo");

                    labelsDao.insert(new LabelEntity(i+1,labelName,labelDesc,labelSuggestion,labelPrice,labelLogo));

                }
            }catch (JSONException e){

                Log.i("TEST", e.getMessage());

            }

            return null;
        }
    }



    private static JSONArray loadJSONArray(Context context){
        StringBuilder builder = new StringBuilder();
        InputStream in = context.getResources().openRawResource(R.raw.labels);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String line;

        try{
            while ((line = reader.readLine())!= null){
                builder.append(line);
            }
            JSONObject json= new JSONObject(builder.toString());
            return json.getJSONArray("labels");
        }catch (IOException | JSONException exception){
            exception.printStackTrace();
        }
        return null;
    }

}
