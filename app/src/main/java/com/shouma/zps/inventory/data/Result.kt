package com.shouma.zps.inventory.data

/**
@date:2022/4/26
@time:9:52 下午
@author:zhaops
@desc:
 */
sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}
