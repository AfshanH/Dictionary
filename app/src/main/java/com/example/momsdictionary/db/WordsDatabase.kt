package com.example.momsdictionary.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class WordsDatabase(context : Context) : SQLiteOpenHelper(context , DataBaseName ,null , DataBaseVersion){


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Tables.CreateAllWordsTable)
        db?.execSQL(Tables.CreateVerbCountTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(Tables.SQL_Delete_WordTable)
        db?.execSQL(Tables.SQL_Delete_VerbTable)
        onCreate(db)
    }

    companion object{
        const val DataBaseName = "wordsDb"
        const val DataBaseVersion = 1
    }
}