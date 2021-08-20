package com.daijinlin.study.jetpack.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker3(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        Log.e("Jetpack", "doWork: [延迟任务] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}")
        return Result.success()
    }
}