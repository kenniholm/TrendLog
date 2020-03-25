package com.example.trendlog.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trendlog.Data.Model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {

    abstract val databaseDao: DatabaseDao

    companion object{

        @Volatile
        private var INSTANCE: com.example.trendlog.Data.Database? = null

        fun getInstance(context: Context) : DatabaseDao {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Database::class.java,
                        "TrendLogDatabase")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

    /*fun login(){
        Log.w("and", "Hello from DB")
    }*/
}