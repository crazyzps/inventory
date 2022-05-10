package com.shouma.zps.inventory.data

import androidx.room.*
import com.shouma.zps.inventory.data.entity.User
import kotlinx.coroutines.flow.Flow


/**
@date:2022/4/27
@time:2:30 下午
@author:zhaops
@desc:
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM users ")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE id=:id")
    fun getUser(id: Long): Flow<User>

    @Query("SELECT * FROM users WHERE userName=:userName")
    fun getUserByUserName(userName: String): Flow<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Delete
    fun deleteAll(users: List<User>)

    @Update
    fun updateUser(newUser: User)

}