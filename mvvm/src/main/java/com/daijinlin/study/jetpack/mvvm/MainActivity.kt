package com.daijinlin.study.jetpack.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * [ViewModel](https://developer.android.google.cn/topic/libraries/architecture/viewmodel)
 *
 * [LiveData](https://developer.android.google.cn/topic/libraries/architecture/livedata)
 *
 * [Lifecycle](https://developer.android.google.cn/topic/libraries/architecture/lifecycle)
 *
 * https://developer.android.com/codelabs/kotlin-android-training-view-model#0
 *
 * https://developer.android.com/codelabs/kotlin-android-training-lifecycles-logging?index=..%2F..android-kotlin-fundamentals#0
 */
class MainActivity : AppCompatActivity() {

    //    private val viewModel: MainViewModel = MainViewModel()
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.liveData.observe(this) {
            Log.d(
                "Jetpack",
                "observe: [LiveData] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}"
            )
            title = it
        }

        findViewById<Button>(R.id.btn).setOnClickListener {
            viewModel.update()
        }

    }
}