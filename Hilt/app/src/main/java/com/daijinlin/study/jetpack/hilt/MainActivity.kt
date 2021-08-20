package com.daijinlin.study.jetpack.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * https://developer.android.google.cn/training/dependency-injection/hilt-android
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}