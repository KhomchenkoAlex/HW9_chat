package com.example.android.hw9Chat.viewModels

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.android.hw9Chat.entities.Message
import com.example.android.hw9Chat.repositories.MessageRepository

class MessageViewModel(application: Application) : BaseViewModel(application) {

    private val repository: MessageRepository = MessageRepository(application)
    private var allMessages: LiveData<List<Message>>

    init {
        allMessages = repository.allMessages
    }

    fun save(message: Message) {
        repository.saveMessage(message)
    }

//    fun update(message: Message) {
////        repository.update(message)
////    }

    fun delete(message: Message) {
        repository.deleteMessage(message)
    }

    fun getAllMessages(): LiveData<List<Message>> {
        return allMessages
    }

}