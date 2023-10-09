package com.daijinlin.study.jetpack.datastore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {

    val liveData: MutableLiveData<String> = MutableLiveData()

    fun write() {
        viewModelScope.launch {

        }
    }

    fun read() {

    }

    fun migration() {

    }

}