package com.shouma.zps.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shouma.zps.inventory.data.entity.Batch
import com.shouma.zps.inventory.data.entity.DataSetting
import com.shouma.zps.inventory.data.entity.UrlSetting
import com.shouma.zps.inventory.data.entity.UserSetting
import java.io.File

/**
@date:2022/4/28
@time:5:19 下午
@author:zhaops
@desc:
 */
@Database(
    entities = [Batch::class, UrlSetting::class, UserSetting::class, DataSetting::class],
    version = 1
)
abstract class InventoryDataBase : RoomDatabase() {

    abstract val inventoryDao: InventoryDao

    companion object {
        private var instance: InventoryDataBase? = null

        @Synchronized
        fun getInstance(context: Context, file: File): InventoryDataBase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(
                context.applicationContext, InventoryDataBase::class.java, file.name
            ).createFromFile(file)
                .build().apply {
                    instance = this
                    instance!!.openHelper.setWriteAheadLoggingEnabled(false)
                }
        }
    }
}