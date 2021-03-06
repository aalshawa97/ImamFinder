package com.example.detailapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.detailapplication.ImamDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Imam::class), version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun imamDao(): ImamDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var imamDao = database.imamDao()

                    // Delete all content here.
                    imamDao.deleteAll()

                    // Add sample words.
                    var imam = Imam("Idris Akbar", "5039359491", "drawable/_200px_ismail_ibn_musa_menks_talk_at_kerala_state_business_excellence_awards_2015")
                    imamDao.insert(imam)
                    //imam = Imam("Mahdi Ahmed!")
                    //imamDao.insert(imam)

                    // TODO: Add your own words!
                    //imam = Imam("Sulaymaan Mustafa!")
                    //imamDao.insert(imam)
                }
            }
        }

    }

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): WordRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                )
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}