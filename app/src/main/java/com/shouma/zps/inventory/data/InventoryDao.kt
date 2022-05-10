package com.shouma.zps.inventory.data

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.shouma.zps.inventory.data.entity.Batch
import kotlinx.coroutines.flow.Flow

/**
@date:2022/4/28
@time:5:20 下午
@author:zhaops
@desc:
 */
@Dao
interface InventoryDao {
    @RawQuery()
    fun getAssets(query: SupportSQLiteQuery): Cursor

    @Query("SELECT * FROM Batch")
    fun getBatch(): Flow<Batch>
}