package com.example.detailapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImamDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(imam: Imam)

    //@Query("SELECT * FROM Imam WHERE title LIKE :Imam ")
    fun findNote(Imam: Imam?): List<Imam?>?

    //@get:Query("SELECT * from Imam ORDER BY title ASC")
    val allNotes: List<Imam?>?

    @Update
    fun update(Imam: Imam?)

    @Query("DELETE FROM Imam")
    fun deleteAllNotes()
    fun deleteAll()

    @Query("SELECT * FROM imam_table ORDER BY imam ASC")
        fun getAlphabetizedWords(): LiveData<List<Imam>>
}