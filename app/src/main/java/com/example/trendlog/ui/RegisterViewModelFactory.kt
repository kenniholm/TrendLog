package com.example.trendlog.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trendlog.data.LoginRepository
import java.lang.IllegalArgumentException

class RegisterViewModelFactory(
    private val app: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            return RegisterViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}