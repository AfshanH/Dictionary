package com.example.momsdictionary.db

object Tables {

    const val word = "word"
    const val pronunciation = "pronunciation"
    const val meaning = "meaning"
    const val example = "example"
    const val Khalaji_syn = "Khalaji_syn"
    const val synExample = "synExample"
    const val partOfSpeech = "partOfSpeech"
    const val verbCount = "verbCount"
    const val idioms = "idioms"
    const val categories = "categories"
    const val I = "I"
    const val You1: String = "You1"
    const val She: String = "She"
    const val We: String = "We"
    const val You2: String = "You2"
    const val They: String = "They"
    const val VerbTense: String = "VerbTense"
    const val AllWordsTable: String = "AllWordsTable"
    const val VerbCountTable: String = "VerbCountTable"


    const val CreateAllWordsTable = "CREATE TABLE $AllWordsTable (" +
            "id INTEGER AUTO INCREMENT ," +
            "$word TEXT PRIMARY KEY," +
            "$pronunciation TEXT," +
            "$meaning TEXT," +
            "$example TEXT," +
            "$Khalaji_syn TEXT," +
            "$synExample TEXT," +
            "$partOfSpeech INTEGER," +
            "$verbCount INTEGER," +
            "$idioms TEXT," +
            "$categories INTEGER)"

    const val SQL_Delete_WordTable = "DROP TABLE IF EXISTS $AllWordsTable"

    const val CreateVerbCountTable = "CREATE TABLE $VerbCountTable ( " +
            "id INTEGER AUTO INCREMENT ," +
            "$word TEXT" +
            "$I TEXT," +
            "$You1 TEXT," +
            "$She TEXT," +
            "$We TEXT," +
            "$You2 TEXT," +
            "$They TEXT," +
            "$VerbTense INTEGER )"

    const val SQL_Delete_VerbTable = "DROP TABLE IF EXISTS $VerbCountTable"


}


