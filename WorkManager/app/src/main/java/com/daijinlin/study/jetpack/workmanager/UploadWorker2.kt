package com.daijinlin.study.jetpack.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker2(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        Log.i("Jetpack", "doWork: [条件任务] ${this.javaClass.simpleName} ::: ${Thread.currentThread().name}")
        return Result.success()
    }
}