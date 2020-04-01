package com.example.trendlog.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.trendlog.data.LoginRepository

class LoginViewModel(val app: Application) : ViewModel() {

    private val repo = LoginRepository(app)
    val userData = repo.userData


    fun login(eMail: String, passWord: String) {
        repo.login(eMail, passWord)
    }
}
