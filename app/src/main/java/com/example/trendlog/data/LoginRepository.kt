package com.example.trendlog.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.trendlog.data.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginRepository(val app: Application) {

    private val db = DataSource.getInstance(app).userDao()
    val userData = MutableLiveData<User>()

    // Launches new thread to register the user to the DB
    fun register(userName: String, passWord: String, eMail: String){
        CoroutineScope(Dispatchers.IO).launch{
            val userExist = db.checkEmailExist(eMail)
            if (!userExist){
                val user = User(userName = userName, passWord = passWord, eMail = eMail, userID = 0)
                db.registerUser(user)
                userData.postValue(user)
            }
            else{
                userData.postValue(null)
            }
        }
    }
    fun login(eMail: String, passWord: String){
        CoroutineScope(Dispatchers.IO).launch {
            val userExist = db.checkEmailExist(eMail)
            if (userExist){
                val user = db.getUser(eMail, passWord)
                userData.postValue(user)
            }
            else{
                userData.postValue(null)
            }
        }
    }
}