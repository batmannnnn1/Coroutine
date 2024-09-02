package com.example.coroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity2 : AppCompatActivity() {
       private val TAG = "KOTLIN"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


    }


    /*
     we have two types Coroutine Builder which helps to build the coroutine:
      launch -> Returns the job object also called the fire and forget!
      async -> Returns the result deferred object and last object type decide the deferred object type because it is generic in nature:
      also async function independently call the suspended functions
           it helps to manage the coroutines
     */

//    private suspend fun printFollower(){
//        var fbFollower = 0
//        val job = CoroutineScope(Dispatchers.IO).launch {
//            fbFollower = getFBFollower()
//        }
//        job.join() // its wait for the coroutine to finish their work and after that it'll be execute the next line:
//        Log.d(TAG,fbFollower.toString())
//
//    }

    private suspend fun printFollower(){

        val job = CoroutineScope(Dispatchers.IO).async {
            getInstaFollower()  // Deferred Object type is int:
        }
        Log.d(TAG, job.await().toString())


    }


/*

The suspend keyword in Kotlin indicates that a function can be paused and resumed at a later time. When a suspend function is called, it doesn't block the current thread. Instead, it allows the thread to perform other work while waiting for the operation to complete. This is particularly useful for long-running tasks like fetching data from an API.

Example Explanation:

When you call a suspend function to fetch data from an API, the function may take some time to complete.
During this time, the function enters a suspended state, allowing the current thread to execute other tasks, instead of being blocked.
Once the data is fetched, the function resumes, and the thread continues executing the rest of the code.


 */
    suspend fun getInstaFollower():Int{
        delay(1000)
        return 54
    }

    suspend fun getFBFollower():Int{
        delay(1000) // suspension point
        return 10
    }

}