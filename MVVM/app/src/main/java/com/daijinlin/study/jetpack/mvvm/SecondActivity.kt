package com.daijinlin.study.jetpack.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class SecondActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        lifecycle.addObserver(LifecycleWatcher())

        findViewById<TextView>(R.id.tv).setOnClickListener {
            viewModel.post()
        }
    }
}