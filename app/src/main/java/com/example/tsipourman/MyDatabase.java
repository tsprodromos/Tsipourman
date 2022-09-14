package com.example.tsipourman;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {UserEntity.class,LabelEntity.class}, version =  2)
public abstract class MyDatabase extends RoomDatabase {

    private static final String dbName = "mydb";

    private static MyDatabase myDatabase;
    public LabelsDao labelsDao;

    public abstract UserDao userDao();
    public abstract LabelsDao labelsDao();
    

    public static synchronized MyDatabase getMyDatabase(Context context){

        if(myDatabase == null){
            myDatabase = Room.databaseBuilder(context, MyDatabase.class,dbName)
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
            labelsDao.insert(new LabelEntity(1,
                    "Μήλος",
                    "Απόσταγμα στέμφυλων (τσίκουδα) και Παλαιωμένο απόσταγμα από το υπόσκαφο οινοποιείο του Κωνσταντάκη (Kostantakis Milos Cave Winery) στα έγκατα της ηφαιστειογενούς Μήλου.", "Παξιμάδι με κάνναβη.\n Γραβιέρα premium με 4 πιπέρια.",
                    "330ml",
                    "5€",
                    "https://imageproxy.wolt.com/menu/menu-images/615329284e88f5797fb4167c/7056382c-20fd-11ec-9f07-8e926c1a41c3_product__56_.jpeg"));
            return null;
        }
    }

}
