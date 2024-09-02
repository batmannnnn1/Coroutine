package com.example.coroutine

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var counter:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         counter = findViewById<TextView>(R.id.counter)
         var button = findViewById<Button>(R.id.button)

          button.setOnClickListener {
              updateCounter()
          }
    }

    fun updateCounter(){
        counter.text = "${counter.text.toString().toInt()+1}"
    }

    private fun longTask(){
        for (i in 1..1000){

        }
    }


    fun doAction(){
        CoroutineScope(Dispatchers.IO).launch {
           Log.d("TAG", Thread.currentThread().name)
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d("TAG", Thread.currentThread().name)
        }

        MainScope().launch(Dispatchers.Default) {
            Log.d("TAG", Thread.currentThread().name)
        }
    }
}