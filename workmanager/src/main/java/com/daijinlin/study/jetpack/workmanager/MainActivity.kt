package com.daijinlin.study.jetpack.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.PermissionRequest
import androidx.work.*
import java.util.concurrent.TimeUnit

/**
 * [WorkManager](https://developer.android.google.cn/topic/libraries/architecture/workmanager)
 * https://zhuanlan.zhihu.com/p/78599394
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 单个任务
    fun test1(view: View) {
        val request = OneTimeWorkRequest.Builder(UploadWorker1::class.java).build()
        WorkManager.getInstance(this).enqueue(request)

//        WorkManager.getInstance(this).cancelWorkById(request.id)
//        WorkManager.getInstance(this).getWorkInfosByTag("jetpack")
//        WorkManager.getInstance(this).cancelAllWorkByTag("jetpack")
    }

    // 条件任务
    fun test2(view: View) {
        val constraints: Constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
//            .setRequiresDeviceIdle(false)
//            .setRequiresStorageNotLow(false)
            .build()
        val request = OneTimeWorkRequest.Builder(UploadWorker2::class.java)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(this).enqueue(request)
    }

    // 延迟任务
    fun test3(view: View) {
        Log.e("Jetpack", "doWork: [延迟任务] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}")
        val request = OneTimeWorkRequest.Builder(UploadWorker3::class.java)
            .setInitialDelay(2, TimeUnit.SECONDS) //符合触发条件后，延迟10秒执行
            .build()
        WorkManager.getInstance(this).enqueue(request)
    }

    // TODO 定时任务
    fun test4(view: View) {
        Log.v("Jetpack", "doWork: [重复任务] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}")
        val request = PeriodicWorkRequest.Builder(UploadWorker4::class.java, 2, TimeUnit.SECONDS)
            .build()
        WorkManager.getInstance(this).enqueue(request)
    }

    // 顺序任务
    fun test5(view: View) {
        Log.w("Jetpack", "---------------------------------------------------")
        val request1 = OneTimeWorkRequest.Builder(UploadWorker1::class.java).build()
        val request2 = OneTimeWorkRequest.Builder(UploadWorker2::class.java).build()
        val request3 = OneTimeWorkRequest.Builder(UploadWorker3::class.java).build()
        val request4 = OneTimeWorkRequest.Builder(UploadWorker4::class.java).build()
        val request5 = OneTimeWorkRequest.Builder(UploadWorker5::class.java).build()
        WorkManager.getInstance(this)
            .beginWith(listOf(request4, request2, request3, request1))
            .then(request5)
            .enqueue()
    }

    // 传值任务
    fun test6(view: View) {
        Log.w("Jetpack", "---------------------------------------------------")
        val data = Data.Builder().putString("jetpack", "workermanager").build()

        val request = OneTimeWorkRequest.Builder(UploadWorker6::class.java)
            .setInputData(data)
            .build()
        WorkManager.getInstance(this).enqueue(request)
    }

    fun test7(view: View) {
        Log.w("Jetpack", "---------------------------------------------------")
        val request1 = OneTimeWorkRequest.Builder(UploadWorker1::class.java).build()
        val request2 = OneTimeWorkRequest.Builder(UploadWorker2::class.java).build()
        val request3 = OneTimeWorkRequest.Builder(UploadWorker3::class.java).build()
        val request4 = OneTimeWorkRequest.Builder(UploadWorker4::class.java).build()
        val request5 = OneTimeWorkRequest.Builder(UploadWorker5::class.java).build()
        val chainAC = WorkManager.getInstance(this)
            .beginWith(request2)
            .then(request1)
        val chainBD = WorkManager.getInstance(this)
            .beginWith(request5)
            .then(request3)
        val chainAll = WorkContinuation
                .combine(listOf(chainAC, chainBD))
            .then(request4)
        chainAll.enqueue()

    }
}