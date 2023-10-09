package com.daijinlin.study.jetpack.mvvm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

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
//    private val viewModel: MainViewModel by viewModels()
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

        findViewById<Button>(R.id.btn1).setOnClickListener {
            viewModel.update()
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }


    }
}