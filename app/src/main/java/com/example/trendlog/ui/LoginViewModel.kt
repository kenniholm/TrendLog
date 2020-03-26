package com.example.trendlog.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.trendlog.data.LoginRepository

class LoginViewModel(app: Application) : ViewModel() {

    private val loginRepo = LoginRepository(app)
    val userData = loginRepo.userData


    fun login(eMail: String, passWord: String) {
        loginRepo.login(eMail, passWord)
    }
}
