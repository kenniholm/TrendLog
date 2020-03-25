package com.example.trendlog.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.trendlog.data.LoginRepository

class LoginViewModel() : ViewModel() {

    //private val _loginRepo = LoginRepository(app)


    fun login(){
        //loginRepo.login()
        Log.w("hello","from Viewmodel")
    }
    fun registerUser(){

    }
}
