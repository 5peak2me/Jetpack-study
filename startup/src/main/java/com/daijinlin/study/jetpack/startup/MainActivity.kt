package com.daijinlin.study.jetpack.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * [Startup](https://developer.android.google.cn/topic/libraries/app-startup)
 * https://blog.csdn.net/qq_40909351/article/details/106726204
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}