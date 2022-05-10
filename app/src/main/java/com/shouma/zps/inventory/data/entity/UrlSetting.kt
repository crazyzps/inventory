package com.shouma.zps.inventory.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
@date:2022/4/28
@time:6:47 下午
@author:zhaops
@desc:
 */
@Entity
data class UrlSetting(
    @PrimaryKey @ColumnInfo(name = "ID") val id: Int,
    @ColumnInfo(name = "Url")
    val url: String?,
    @ColumnInfo(name = "Code")
    val code: String?,
    @ColumnInfo(name = "Authorization")
    val authorization: String?,
    @ColumnInfo(name = "Batchid")
    val batchId: String?,
    @ColumnInfo(name = "OutType")
    val outType: String?
)
