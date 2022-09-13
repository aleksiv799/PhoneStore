package com.my.udacity.phonestore.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {

    private val _phoneList = MutableLiveData<List<Phone>>()
    val phoneList: LiveData<List<Phone>>
        get() = _phoneList

    fun addPhone(phone: Phone) {
        val list = _phoneList.value?.toMutableList() ?: mutableListOf()
        list.add(phone)
        _phoneList.value = list
    }

}