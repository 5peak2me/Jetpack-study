package com.daijinlin.study.jetpack.datastore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * https://developer.android.com/topic/libraries/architecture/datastore?hl=zh-cn
 * https://developer.android.com/codelabs/android-preferences-datastore?hl=zh-cn#0
 * https://developer.android.com/codelabs/android-proto-datastore?hl=zh-cn#0
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}