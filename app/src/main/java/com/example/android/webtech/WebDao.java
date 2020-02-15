package com.example.android.webtech;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WebDao {
    @Query("SELECT * from web_table ORDER BY word ASC")
    LiveData<List<MainActivity.Word>> getAllWords();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MainActivity.Word word);

    @Query("DELETE FROM web_table")
    void deleteAll();

    @Query("SELECT * FROM web_table ORDER BY RANDOM() LIMIT 1")
    LiveData<MainActivity.Word> getAny();


}
