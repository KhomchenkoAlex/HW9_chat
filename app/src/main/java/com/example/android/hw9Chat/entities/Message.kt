package com.example.android.hw9Chat.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Message(
    @ColumnInfo(name = "user")
    val username: String,

    @ColumnInfo(name = "text")
    val text: String
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}