package com.example.detailapplication

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.chrono.HijrahChronology.INSTANCE
/*
private class WordDatabaseCallback(
    private val scope: CoroutineScope
) : RoomDatabase.Callback() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        INSTANCE?.let { database ->
            scope.launch {
                populateDatabase(database.imamDao())
            }
        }
    }

    suspend fun populateDatabase(wordDao: imamDao) {
        // Delete all content here.
        wordDao.deleteAll()

        // Add sample words.
        var word = Imam("Hello")
        wordDao.insert(word)
        word = Imam("World!")
        wordDao.insert(word)

        // TODO: Add your own words!
        word = Imam("Imam!")
        wordDao.insert(word)
    }
}
 */