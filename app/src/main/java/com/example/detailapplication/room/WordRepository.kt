package com.example.detailapplication.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.detailapplication.Imam
import com.example.detailapplication.ImamDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WordRepository(private val imamDao: ImamDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Imam>> = imamDao.getAlphabetizedWords()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Imam) {
        imamDao.insert(word)
    }
}