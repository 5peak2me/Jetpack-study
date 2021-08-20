package com.daijinlin.study.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.daijinlin.study.jetpack.databinding.databinding.ActivityMainBinding
import java.lang.Thread.sleep
import kotlin.concurrent.thread

/**
 * [DataBinding](https://developer.android.google.cn/topic/libraries/data-binding)
 * https://www.bilibili.com/video/BV1iX4y1F7Nw
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val activityMain = R.layout.activity_main
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val user = User("daijinlin", "123456")

        binding.user = user

        thread {
            repeat(10) {
                sleep(1000)
                user.username = user.username + "1"
            }
        }
    }
}