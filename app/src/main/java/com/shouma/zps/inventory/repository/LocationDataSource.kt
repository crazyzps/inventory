package com.shouma.zps.inventory.repository

import android.content.Context
import android.database.Cursor
import androidx.sqlite.db.SupportSQLiteQuery
import com.shouma.zps.inventory.data.entity.Asset
import com.shouma.zps.inventory.data.entity.Batch
import kotlinx.coroutines.flow.Flow
import java.io.File

/**
@date:2022/4/25
@time:9:21 下午
@author:zhaops
@desc:
 */
interface LocationDataSource {
    fun getString(key: String, defaultValue: String): String?

    fun saveString(key: String, value: String)

    fun openDb(context: Context, file: File)

    fun closeDb(context: Context, file: File)

    fun getAssets(query: SupportSQLiteQuery): Cursor

    fun getBatch(): Flow<Batch>
}