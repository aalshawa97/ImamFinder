package com.example.detailapplication

import androidx.room.*

@Dao
interface ImamDao {

    @Insert
    fun insert(imam: Imam?)

    //@Query("SELECT * FROM Imam WHERE title LIKE :Imam ")
    fun findNote(Imam: Imam?): List<Imam?>?

    //@get:Query("SELECT * from Imam ORDER BY title ASC")
    val allNotes: List<Imam?>?

    @Update
    fun update(Imam: Imam?)

    @Query("DELETE FROM Imam")
    fun deleteAllNotes()
}