package com.example.momsdictionary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.momsdictionary.db.Entities.Words_Entity


@Database(entities = [Words_Entity::class], version = 1)
abstract class WordsDataBase : RoomDatabase(){


    abstract fun wordsDao() : Dao

    companion object{

        @Volatile private var instance :WordsDataBase? =null
        private val LOCK = Any()

        operator fun invoke (context: Context)= instance ?: synchronized(LOCK){
            instance?: BuildDataBase(context).also {
                instance=it
            }
        }

        private fun BuildDataBase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            WordsDataBase::class.java,
            "noteDataBase"
        ).build()


    }

}