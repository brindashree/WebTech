package com.example.android.webtech;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<MainActivity.Word>> mAllWords;
    public WordViewModel(Application application){
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }
    LiveData<List<MainActivity.Word>> getAllWords() {
        return mAllWords;
    }
    public void insert(MainActivity.Word word) {
        mRepository.insert(word);
    }
}
