package com.shouma.zps.inventory.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
@date:2022/5/7
@time:11:01 上午
@author:zhaops
@desc:
 */
@Entity
data class DataSetting(
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: Int,
    @ColumnInfo(name = "DataTitle")
    val dataTitle: String?,
    @ColumnInfo(name = "DataDetail")
    val dataDetail: String?,
    @ColumnInfo(name = "DataType")
    val dataType: String?,
    @ColumnInfo(name = "DataUpdate")
    val dataUpdate: String?,
    @ColumnInfo(name = "DataBaseColumn")
    val dataBaseColumn: String?,
    @ColumnInfo(name = "DataUpColumn")
    val dataUpColumn: String?,
    @ColumnInfo(name = "DataTitleAll")
    val dataTitleAll: String?
)
