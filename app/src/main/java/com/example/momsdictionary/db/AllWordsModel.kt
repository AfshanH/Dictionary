package com.example.momsdictionary.db

data class wordss(
    var word: String? = null,
    var pronunciation: String? = null,
    var meaning: String? = null,
    var example: String? = null,
    var Khalaji_syn: String? = null,
    var synExample: String? = null,
    var partOfSpeech: Int?=0,
    var verbCount: Int ?=0,
    var idioms: String? = null,
    var categories: Int? = 0 ,
    var id: Int ? =0
        )

class AllWordsModel {
//    var word: String? = null
//    var pronunciation: String? = null
//    var meaning: String? = null
//    var example: String? = null
//    var Khalaji_syn: String? = null
//    var synExample: String? = null
//    var partOfSpeech: Int = 0
//    var verbCount: Int = 0
//    var idioms: String? = null
//    var categories: Int = 0
//    var id: Int = 0


//    fun setWord (word : String){
//        this.word = word
//    }
//
//    fun getWord ():String{
//        return Tables.word
//    }

    //////////////////////////////////////////////////////////////////
    var I: String? = null                                          ///
    var you1: String? = null                                       ///
    var she: String? = null                                        ///
    var we: String? = null                                         ///
    var you2: String? = null                                       ///
    var they: String? = null                                       ///
    var verb_tense: Int = 0                                       ///
    ///
    //////////////////////////////////////////////////////////////////



}