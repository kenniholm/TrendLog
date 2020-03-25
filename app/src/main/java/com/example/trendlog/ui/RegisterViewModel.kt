package com.example.trendlog.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.trendlog.data.LoginRepository

class RegisterViewModel(val app: Application) : ViewModel() {

    private val repo = LoginRepository(app)


    fun register(userName: String, passWord: String, eMail: String){
        repo.register(userName, passWord, eMail)
        Log.w("Hey","you registered ;P")
    }

}
