package com.example.android.webtech;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {MainActivity.Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WebDao webDao();
    private static volatile WordRoomDatabase INSTANCE;

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "web_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onCreate (@NonNull SupportSQLiteDatabase db){
                    super.onCreate(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WebDao mDao;

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.webDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            MainActivity.Word word = new MainActivity.Word("HTML");
            mDao.insert(word);
            word = new MainActivity.Word("CSS");
            mDao.insert(word);
            word = new MainActivity.Word("UX");
            mDao.insert(word);
            word = new MainActivity.Word("SERP");
            mDao.insert(word);
            return null;
        }
    }
}
