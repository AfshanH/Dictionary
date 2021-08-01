package com.example.momsdictionary.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast

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

    fun GetWordsdata(theWord: String?): wordss {
        val db= WordsDatabase(context)
        val dbhelper = db.readableDatabase
        val cursor = dbhelper.query(
            Tables.AllWordsTable,
            arrayOf(
                Tables.word,
                Tables.pronunciation,
                Tables.meaning,
                Tables.example,
                Tables.Khalaji_syn,
                Tables.synExample,
                Tables.partOfSpeech,
                Tables.verbCount,
                Tables.idioms,
                Tables.categories
            ),
            "${Tables.word} =?",
            arrayOf(theWord),
            null,
            null,
            null
        )

        val model = wordss()
        if (cursor != null) while (cursor.moveToNext()) {


            model.word=cursor.getString(cursor.getColumnIndex(Tables.word))
            model.pronunciation=cursor.getString(cursor.getColumnIndex(Tables.pronunciation))
            model.meaning=cursor.getString(cursor.getColumnIndex(Tables.meaning))
            model.example=cursor.getString(cursor.getColumnIndex(Tables.example))
            model.Khalaji_syn=cursor.getString(cursor.getColumnIndex(Tables.Khalaji_syn))
            model.synExample=cursor.getString(cursor.getColumnIndex(Tables.synExample))
            model.partOfSpeech=cursor.getInt(cursor.getColumnIndex(Tables.partOfSpeech))
            model.verbCount=cursor.getInt(cursor.getColumnIndex(Tables.verbCount))
            model.idioms=cursor.getString(cursor.getColumnIndex(Tables.idioms))
            model.categories=cursor.getInt(cursor.getColumnIndex(Tables.categories))
        }
        cursor!!.close()
        db.close()
        return model
    }

    fun UpdateMyWords(model: wordss): Boolean {
        val db = WordsDatabase(context)
        val dbHelper = db.writableDatabase
        val cv = ContentValues()


        cv.put(Tables.word, model.word)
        cv.put(Tables.pronunciation, model.pronunciation)
        cv.put(Tables.meaning, model.meaning)
        cv.put(Tables.example, model.example)
        cv.put(Tables.Khalaji_syn, model.Khalaji_syn)
        cv.put(Tables.synExample, model.synExample)
        cv.put(Tables.partOfSpeech, model.partOfSpeech)
        cv.put(Tables.verbCount, model.verbCount)
        cv.put(Tables.idioms, model.idioms)
        cv.put(Tables.categories, model.categories)

        dbHelper.update(
            Tables.AllWordsTable,
            cv,
            "${Tables.word} = ?",
            arrayOf(model.word)
        )
        return true
    }

    fun DeleteMyWord(deletingWord: String): Boolean {
        val db = WordsDatabase(context)
        val dbHelper = db.writableDatabase
        dbHelper.delete(
            Tables.AllWordsTable,
            "${Tables.word} = ?",
            arrayOf(deletingWord)
        )
        return true
    }
}