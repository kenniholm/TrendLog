package com.example.trendlog.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trendlog.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DataSource: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        // Volatile makes sure other threads are instantly aware of any changes to the state of the instance
        @Volatile
        private var INSTANCE: DataSource? = null
        // Creates new DB if it doesn't exist
        fun getInstance(context: Context) : DataSource {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataSource::class.java,
                        "TrendLogDatabase")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}