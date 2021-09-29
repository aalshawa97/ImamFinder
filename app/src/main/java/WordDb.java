/*package com.abdul.firstapp.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1)
public abstract class WordDb extends RoomDatabase {

    public abstract WordDao wordDao();

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
*/