package com.example.trendlog.ui.dashboard

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trendlog.ui.login.LoginViewModel
import java.lang.IllegalArgumentException

class DashBoardViewModelFactory(
    private val app: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashBoardViewModel::class.java)){
            return DashBoardViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}