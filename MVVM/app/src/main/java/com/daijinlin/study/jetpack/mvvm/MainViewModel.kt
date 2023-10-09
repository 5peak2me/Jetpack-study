package com.daijinlin.study.jetpack.mvvm

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class MainViewModel : ViewModel() {

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    init {
        Log.d(
            "Jetpack",
            "init: [ViewModel] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}"
        )
    }

    fun update() {
        Handler().postDelayed({
            _liveData.value = "我是更新后的值"
        }, 2000)
    }

    fun post() {
        _liveData.value = "我是发送的值"
    }

    override fun onCleared() {
        Log.d(
            "Jetpack",
            "onCleared: [ViewModel] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}"
        )
    }

}