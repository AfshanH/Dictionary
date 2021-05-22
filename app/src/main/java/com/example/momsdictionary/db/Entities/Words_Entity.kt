package com.example.momsdictionary.db.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.momsdictionary.db.Entities.Verbs_Entity


@Entity (tableName = "Words_Entity")
data class Words_Entity (
    @PrimaryKey(autoGenerate = false)
    val khalaji_word : String? = null,

    val pronounciation : String? = null,
    val farsi_def : String? = null,
    val example : String? = null,
    val khalaji_syn : String? = null,
    val example_with_syn : String? = null,
    val partOfSpeech : Int? = 0,
    val verbCount : Verbs_Entity,
    val idioms : String? = null,
    val categories : String? = null
        )