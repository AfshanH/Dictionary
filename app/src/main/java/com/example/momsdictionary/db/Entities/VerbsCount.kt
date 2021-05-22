package com.example.momsdictionary.db.Entities

import androidx.room.Entity

@Entity(tableName = "verbs_count")
data class VerbsCount (
    val I : String? = null,
    val you : String? = null,
    val she : String? =null ,
    val we : String? = null ,
    val youu: String? = null,
    val they : String? = null
        )