package com.shouma.zps.inventory.data.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
@date:2022/4/26
@time:7:15 下午
@author:zhaops
@desc:
 */

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val userName: String?,
    val password: String?,
    val chineseName: String?,
    val linkId: String?,
    val job: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(userName)
        parcel.writeString(password)
        parcel.writeString(chineseName)
        parcel.writeString(linkId)
        parcel.writeString(job)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
