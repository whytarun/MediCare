package com.medicare.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicine")
data class Medicine(
    @PrimaryKey val id :Int? = null,
    val name:String,
    val dose :String,
    val strength: String
)
