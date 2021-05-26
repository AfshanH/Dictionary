package com.example.momsdictionary.db

import java.util.*

class Helper {

    fun words(list: MutableList<wordss>): ArrayList<String?> {
        val texts = ArrayList<String?>()
        for (model in list) {
            texts.add(model.word)
        }
        return texts
    }

    fun wordsMean(list: MutableList<wordss>): ArrayList<String?> {
        val texts = ArrayList<String?>()
        for (model in list) {
            texts.add(model.meaning)
        }
        return texts
    }

}