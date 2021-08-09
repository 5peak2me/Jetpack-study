package com.daijinlin.study.jetpack.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker6(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        val string = inputData.getString("jetpack")
        Log.wtf("Jetpack", "doWork: [单个任务] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name} - $string")
        return Result.success()
    }
}