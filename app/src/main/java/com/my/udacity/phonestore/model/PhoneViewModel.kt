package com.my.udacity.phonestore.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PhoneViewModel() : ViewModel() {

    private val _data = MutableLiveData<Phone>()
    val data: LiveData<Phone>
        get() = _data

    private val _nameIsCorrect = MutableLiveData<Boolean>()
    val nameIsCorrect: LiveData<Boolean>
        get() = _nameIsCorrect

    private val _systemOSIsCorrect = MutableLiveData<Boolean>()
    val systemOSIsCorrect: LiveData<Boolean>
        get() = _systemOSIsCorrect

    private val _companyIsCorrect = MutableLiveData<Boolean>()
    val companyIsCorrect: LiveData<Boolean>
        get() = _companyIsCorrect

    private val _descriptionIsCorrect = MutableLiveData<Boolean>()
    val descriptionIsCorrect: LiveData<Boolean>
        get() = _descriptionIsCorrect

    fun saveData(
        phone: Phone
    ) {
        val (name, systemOS, company, description) = phone
        val nameIsCorrect = name.isNotBlank()
        _nameIsCorrect.value = nameIsCorrect
        val systemOSIsCorrect = systemOS.isNotBlank()
        _systemOSIsCorrect.value = systemOSIsCorrect
        val companyIsCorrect = company.isNotBlank()
        _companyIsCorrect.value = companyIsCorrect
        val descriptionIsCorrect = company.isNotBlank()
        _descriptionIsCorrect.value = descriptionIsCorrect

        val dataIsReady =
            nameIsCorrect && descriptionIsCorrect && companyIsCorrect && descriptionIsCorrect

        if (dataIsReady) {
            _data.value = phone
        }
    }
}
