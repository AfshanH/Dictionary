package com.example.momsdictionary.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.widget.Toast
import com.example.momsdictionary.ui.Insert
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.selects.whileSelect

class Methods(val context: Context) {


    fun insertWords(model: wordss) {

        val dbHelper = WordsDatabase(context)
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(Tables.word, model.word)
            put(Tables.pronunciation, model.pronunciation)
            put(Tables.meaning, model.meaning)
            put(Tables.example, model.example)
            put(Tables.Khalaji_syn, model.Khalaji_syn)
            put(Tables.synExample, model.synExample)
            put(Tables.partOfSpeech, model.partOfSpeech)
            put(Tables.verbCount, model.verbCount)
            put(Tables.idioms, model.idioms)
            put(Tables.categories, model.categories)
        }
        val result = db.insert(Tables.AllWordsTable, null, values)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }


    fun getData(): MutableList<wordss> {

        val dbHelper = WordsDatabase(context)
        val db = dbHelper.readableDatabase

        val cursor = db.rawQuery("select * from ${Tables.AllWordsTable}", null)
        val item: MutableList<wordss> = ArrayList()
        with(cursor) {
            while (moveToNext()) {
                val model = wordss()

                model.word = getString(getColumnIndex(Tables.word))
                model.pronunciation = getString(getColumnIndex(Tables.pronunciation))
                model.meaning = getString(getColumnIndex(Tables.meaning))
                model.example = getString(getColumnIndex(Tables.example))
                model.Khalaji_syn = getString(getColumnIndex(Tables.Khalaji_syn))
                model.synExample = getString(getColumnIndex(Tables.synExample))
                model.partOfSpeech = getInt(getColumnIndex(Tables.partOfSpeech))
                model.verbCount = getInt(getColumnIndex(Tables.verbCount))
                model.idioms = getString(getColumnIndex(Tables.idioms))
                model.categories = getInt(getColumnIndex(Tables.categories))

                item.add(model)
            }


            return item

        }

    }
}