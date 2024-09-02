package com.example.coroutine

/*
Your Program[Set of instruction] will execute on a process
Process execute your program via Main Thread...

Main thread don't handle the big task they handle only the updating the Ui...
when you execute some big task on them your app will be crashed...

in java we will use background thread for executing the big task like fetch data from api...
but we have limited set of threads... also it's to heavy create everytime threads..

but in kotlin we have Coroutine and it will be cheaper than coroutines
you can create many coroutines in one thread...

Coroutine is a special type function which is cooperative with other coroutine functions...

when you raised data request from the api so it'll be take some time if you doing this at thread
thread will blocked at not doing any task until the data comes from api...
but when you doing this at coroutines thread will not blocked thread will free to do other task...
when data comes from api thread will back and complete the remaining task...

Note- it is not necessary that same thread will back to complete task we have thread pool for this
what's the thread pool ? -> Set of threads
any thread will comes from thread pool to finish this task...

                how to declare the Coroutine ?
  Scope-> It defines the lifetime of coroutine like GlobalScope,CoroutineScope,MainScope,ViewModelScope
  the scope attached from the component when component destroy the coroutine will also destroy

 Context-> It defines at which thread you have to run your coroutine
 Dispatcher Provides some thread info like Main,IO,Default

Coroutine Builder which is used for build the coroutine:
launch
async

these coroutine builder it's an non-blocking in nature:
but we have two which is blocking in nature:

withContext-> suspend the coroutine not blocks the thread means first coroutine finish their work then other works started executing...
runblocking -> blocks the thread


 */