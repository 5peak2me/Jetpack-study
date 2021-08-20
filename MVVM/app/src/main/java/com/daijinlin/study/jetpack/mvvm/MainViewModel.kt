package com.daijinlin.study.jetpack.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel : ViewModel() {

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData;

    init {
        Log.d(
            "Jetpack",
            "init: [ViewModel] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}"
        )
    }

    fun update() {
        sleep(3000L)
        _liveData.value = "我是更新后的值"
    }

    override fun onCleared() {
        Log.d(
            "Jetpack",
            "onCleared: [ViewModel] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}"
        )
    }

}