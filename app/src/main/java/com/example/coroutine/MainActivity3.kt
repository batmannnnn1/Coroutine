package com.example.coroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity3 : AppCompatActivity() {
    private val TAG = "KOTLIN"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

    }

    /*
    it is not easy to cancel the coroutine while they doing some big task
    if you call the cancel so coroutine will be cancel but the thread still doing your task they didn't know about coroutine is cancelled:

    so prevent this situation we will use the checked statement:
     */
    private fun longRunningTask(){
        for(i in 1..1000){

        }

    }

    private suspend fun cancel(){
        var parentJob = GlobalScope.launch(Dispatchers.IO) {
            for (i in 1..1000){
                if (isActive){
                    longRunningTask()
                }

            }

        }

        delay(100)
        parentJob.cancel()
    }



/*
           JOB HIERARCHY
  You can create multiple coroutine in one coroutine
  And it'll creates the parent child relation between Coroutines
     */

    private suspend fun execute(){
        var parentJob = GlobalScope.launch(Dispatchers.Main) {

            var childJob = launch {
                try {


                    Log.d(TAG, "Child Job Started")
                    delay(5000)
                    Log.d(TAG, "Child Job Ended")
                }
                catch (e:CancellationException){
                    Log.d(TAG, "Child Job Cancelled")
                }
            }
            delay(3000)
            childJob.cancel()
            Log.d(TAG, "Parent Ended")
        }

        parentJob.join() // it will wait for child complete their work and then parent job will become completed...
        Log.d(TAG, "Parent Completed")
    }




}