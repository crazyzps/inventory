package com.shouma.zps.inventory.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
@date:2022/4/28
@time:6:36 下午
@author:zhaops
@desc:
 */
@Entity
data class UserSetting(
    @PrimaryKey @ColumnInfo(name = "ID") val id: Int,
    @ColumnInfo(name = "UserTitle")
    val userTitle: String?,
    @ColumnInfo(name = "UserDetail")
    val userDetail: String?,
    @ColumnInfo(name = "UserType")
    val userType: String?,
    @ColumnInfo(name = "Memo")
    val memo: String?
)
