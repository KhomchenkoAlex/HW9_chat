package com.example.android.hw9Chat.repositories

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.android.hw9Chat.dao.MessageDao
import com.example.android.hw9Chat.db.ChatDatabase
import com.example.android.hw9Chat.entities.Message

class MessageRepository(application: Application) {

    private val messageDao: MessageDao
    val allMessages: LiveData<List<Message>>

    init {
        val database = ChatDatabase.getDatabase(application)
        messageDao = database.messageDao()
        allMessages = messageDao.getAllMessage()
    }
    
    fun saveMessage(message: Message) {
        SaveMessageAsyncTask(messageDao).execute(message)
    }

    fun deleteMessage(message: Message) {
        DeleteMessageAsyncTask(messageDao).execute(message)
    }
}

private class SaveMessageAsyncTask (private val messageDao: MessageDao) : AsyncTask<Message, Void, Void>() {
    override fun doInBackground(vararg params: Message): Void? {
        messageDao.save(params.first())
        return null
    }
}
private class DeleteMessageAsyncTask (private val messageDao: MessageDao) : AsyncTask<Message, Void, Void>() {
    override fun doInBackground(vararg messages: Message): Void? {
        messageDao.delete(messages.first())
        return null
    }
}
private class GetAllMessageAsyncTask(private val messageDao: MessageDao) : AsyncTask<Message, Void, Void>() {
    override fun doInBackground(vararg messages: Message): Void? {
        messageDao.getAllMessage()
        return null
    }
}