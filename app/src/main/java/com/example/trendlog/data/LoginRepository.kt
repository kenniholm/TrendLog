package com.example.trendlog.Data

import android.util.Log

class LoginRepository {

    private val dataSrc = DataSource()

    fun login(){
        dataSrc.login()
        Log.w("hello","from repo!")
    }
    fun logout(){

    }
    fun register(){

    }
}