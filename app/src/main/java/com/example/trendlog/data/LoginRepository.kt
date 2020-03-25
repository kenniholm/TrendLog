package com.example.trendlog.data

import android.app.Application
import com.example.trendlog.data.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginRepository(val app: Application) {

    private val userData = DataSource.getInstance(app).userDao()

    // Launches new thread to register the user to the DB
    fun register(userName: String, passWord: String, eMail: String){
        CoroutineScope(Dispatchers.IO).launch{
            var user = User(userName = userName, passWord = passWord, eMail = eMail, userID = 0)
            userData.registerUser(user)
        }
    }
}