package com.example.trendlog.UI

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.trendlog.Data.LoginRepository

class LoginViewModel() : ViewModel() {

    private val loginRepo = LoginRepository()

    fun login(){
        loginRepo.login()
        Log.w("hello","from Viewmodel")
    }
}
