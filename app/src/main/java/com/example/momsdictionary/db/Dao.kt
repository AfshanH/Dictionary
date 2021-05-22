package com.example.momsdictionary.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.momsdictionary.db.Entities.Words_Entity


@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWord(words : Words_Entity)

    @Query("select *  from Words_Entity")
    fun getWords() : LiveData<List<Words_Entity>>

    @Delete
    fun deleteItems(words: Words_Entity)

    @Update
    fun updateItems(words: Words_Entity)

}