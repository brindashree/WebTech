package com.example.android.webtech;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private  WebDao mWebDao;
    private LiveData<List<MainActivity.Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWebDao = db.webDao();
        mAllWords = mWebDao.getAllWords();
    }
    LiveData<List<MainActivity.Word>> getAllWords() {
        return mAllWords;
    }
    public void insert (MainActivity.Word word) {
        new insertAsyncTask(mWebDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<MainActivity.Word,Void,Void>{
        private  WebDao mAsyncTaskDao;
        insertAsyncTask(WebDao dao){
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final MainActivity.Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;

        }
    }
}
