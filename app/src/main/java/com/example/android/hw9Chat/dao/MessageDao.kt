package com.example.android.hw9Chat.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.android.hw9Chat.entities.Message


@Dao
interface MessageDao {

    @Insert
    fun save(message: Message)

    @Delete
    fun delete(message: Message)

    @Query("SELECT * FROM messages")
    fun getAllMessage(): LiveData<List<Message>>
}