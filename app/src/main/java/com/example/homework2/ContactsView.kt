package com.example.homework2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactsView : ViewModel() {

    private val _contacts = MutableLiveData<MutableList<Person>>()

    // Initialize the list
    init {
        _contacts.value = mutableListOf()
    }

    val contacts: LiveData<MutableList<Person>>
        get() = _contacts

    fun addContact(person: Person) {
        _contacts.value?.add(person)
        _contacts.postValue(_contacts.value)
    }
}
