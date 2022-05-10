package com.shouma.zps.inventory.repository

import android.content.Context
import androidx.sqlite.db.SupportSQLiteQuery
import com.shouma.zps.inventory.data.InventoryDao
import com.shouma.zps.inventory.data.InventoryDataBase
import com.tencent.mmkv.MMKV
import java.io.File


/**
@date:2022/4/25
@time:9:18 下午
@author:zhaops
@desc:
 */
class InventoryRepository(private val kv: MMKV) : RemoteDataSource, LocationDataSource {

    lateinit var inventoryDao: InventoryDao

    override fun getString(key: String, defaultValue: String) = kv.getString(key, defaultValue)

    override fun saveString(key: String, value: String) {
        kv.encode(key, value)
    }

    override fun openDb(context: Context, file: File) {
        inventoryDao = InventoryDataBase.getInstance(context, file).inventoryDao
    }

    override fun closeDb(context: Context, file: File) {
        inventoryDao
    }

    override fun getAssets(query: SupportSQLiteQuery) = inventoryDao.getAssets(query)


    override fun getBatch() = inventoryDao.getBatch()


}