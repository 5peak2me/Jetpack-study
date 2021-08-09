package com.daijinlin.study.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * [DataBinding](https://developer.android.google.cn/topic/libraries/data-binding)
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}