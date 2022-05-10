package com.shouma.zps.inventory.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
@date:2022/4/28
@time:5:22 下午
@author:zhaops
@desc:
 */
@Entity
data class Batch(
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: Int,
    @ColumnInfo(name = "BatchCode")
    val batchCode: String?,
    @ColumnInfo(name = "BatchKey")
    val batchKey: String?,
    @ColumnInfo(name = "BatchMemo")
    val batchMemo: String?,
    @ColumnInfo(name = "BatchStatus")
    val batchStatus: String?,
    @ColumnInfo(name = "StartTime")
    val startTime: String?,
    @ColumnInfo(name = "EndTime")
    val endTime: String?
)
