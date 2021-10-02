package com.example.detailapplication.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.detailapplication.Imam;

@Database(entities = {Imam.class}, version = 1)
public abstract class WordDb extends RoomDatabase {

    public abstract Imam imamDao();

    private static WordDb INSTANCE;

    public static WordDb getNoteDb(Context context) {
        if (INSTANCE == null) {
            synchronized (WordDb.class) {
                INSTANCE = Room.databaseBuilder(context, WordDb.class, "worddb")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }


}