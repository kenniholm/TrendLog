package com.example.trendlog.Data.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UserDAO(
    @PrimaryKey(autoGenerate = true)
    var userID: Long,
    @ColumnInfo(name = "user_display_name")
    var userName:String,
    @ColumnInfo(name = "user_password")
    var passWord:String,
    @ColumnInfo(name = "user_email")
    var eMail:String)