package com.example.trendlog.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.trendlog.data.model.User

@Dao
interface UserDao {
    @Insert
    fun registerUser(user: User)

    @Query("SELECT * FROM users WHERE user_email = :eMail AND user_password = :passWord")
    fun checkUserLogin(eMail: String, passWord: String): User?
}