package com.shouma.zps.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shouma.zps.inventory.data.entity.User
import com.shouma.zps.inventory.utilities.DATABASE_APP

/**
@date:2022/4/27
@time:2:46 下午
@author:zhaops
@desc:
 */
@Database(version = 1, entities = [User::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_APP
            )
                .build().apply {
                    instance = this
                }
        }
    }
}