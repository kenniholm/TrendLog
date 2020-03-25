package com.example.trendlog.data

import androidx.room.Dao
import androidx.room.Insert
import com.example.trendlog.data.model.User

@Dao
interface UserDao {
    @Insert
    fun registerUser(user: User)
}