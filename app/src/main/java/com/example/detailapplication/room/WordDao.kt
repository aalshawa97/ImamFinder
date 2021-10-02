package com.example.detailapplication

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.detailapplication.room.Imam

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

    @Query("DELETE FROM imam_table")
    fun deleteAllNotes()
    fun deleteAll()

    @Query("SELECT * FROM imam_table ORDER BY imam ASC")
        fun getAlphabetizedWords(): LiveData<List<Imam>>
}