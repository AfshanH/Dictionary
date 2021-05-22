package com.example.momsdictionary.db.Entities

import androidx.room.Entity

@Entity(tableName = "Verbs_Table")
data class Verbs_Entity (
    val simple_past : VerbsCount,
    val present_perfect : VerbsCount,
    val past_perfect : VerbsCount,
    val past_continues : VerbsCount,
    val past_subjunctive : VerbsCount,
    val very_past_perfect : VerbsCount,
    val present_perfect_continues : VerbsCount,
    val malmoosPast : VerbsCount,
    val simple_present : VerbsCount,
    val present_continues : VerbsCount,
    val present_subjunctive : VerbsCount,
    val future : VerbsCount,
    val imperative : VerbsCount,
    val negative : VerbsCount
        )