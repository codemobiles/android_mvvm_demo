package com.codemobiles.android.cmdroidmvvmdemo.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val counter2 = MutableLiveData<Int>(0)
    val toastCmd = MutableLiveData<ToastCommand>()


    fun doSomething(){
//    counter2.value = counter2.value!! + 1
      counter2.apply { value = value!! + 1 }


      // Update UI by toast it
      toastCmd.apply {
//          value?.cmd = "CMD_TOAST"
//          value?.payload = "I Love CodeMobiles.com"

          value = ToastCommand(cmd= "CMD_TOAST", payload = "I Love CodeMobiles.com")
      }
    }
}