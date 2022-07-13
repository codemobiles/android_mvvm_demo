package com.codemobiles.android.cmdroidmvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.codemobiles.android.cmdroidmvvmdemo.viewmodel.AppViewModelFactory
import com.codemobiles.android.cmdroidmvvmdemo.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    var counter1 = 0
    private lateinit var viewModel:MainViewModel
    private val factory = AppViewModelFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup viewmodel
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        setObserve()
        updateDisplay()
    }

    private fun setObserve() {
        viewModel.counter2.observe(this){
            updateDisplay()
        }

        viewModel.toastCmd.observe(this){
            if (it.cmd == "CMD_TOAST"){
                Toast.makeText(applicationContext, it.payload, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun handleClickBtn1(view: View) {
        counter1 = counter1 + 1
        updateDisplay()
    }

    private fun updateDisplay() {
        setTitle("$counter1/${viewModel.counter2.value}")
    }


    fun handleClickBtn2(view: View) {
       viewModel.doSomething()
    }
}