package com.shouma.zps.inventory.repository

import com.shouma.zps.inventory.data.entity.User
import com.shouma.zps.inventory.data.UserDao
import com.tencent.mmkv.MMKV

/**
@date:2022/4/27
@time:3:31 下午
@author:zhaops
@desc:
 */
class UserRepository constructor(private val userDao: UserDao) {
    fun getUsers() = userDao.getUsers()

    fun getUser(id: Long) = userDao.getUser(id)

    fun getUserByUserName(userName: String) = userDao.getUserByUserName(userName)

    fun insertAll(users: List<User>) = userDao.insertAll(users)

    fun deleteAll(users: List<User>) = userDao.deleteAll(users)

    fun updateUser(newUser: User) = userDao.updateUser(newUser)

    fun saveCurrentUser(user: User) {
        MMKV.defaultMMKV().encode("user", user)
    }
}