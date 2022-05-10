package com.shouma.zps.inventory.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.shouma.zps.inventory.repository.UserRepository

/**
@date:2022/4/26
@time:11:37 上午
@author:zhaops
@desc:
 */
class LoginViewModel(private val repo: UserRepository) : ViewModel() {

    val userName = ObservableField("")

    val password = ObservableField("")

    fun register(userName: String, password: String) {

    }
}