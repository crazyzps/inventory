package com.shouma.zps.inventory.vm

import androidx.lifecycle.ViewModel
import com.shouma.zps.inventory.R
import com.shouma.zps.inventory.data.entity.Action
import com.shouma.zps.inventory.repository.InventoryRepository
import com.shouma.zps.inventory.utilities.*

/**
@date:2022/4/25
@time:8:48 下午
@author:zhaops
@desc:
 */
class MainViewModel(private val repo: InventoryRepository) : ViewModel() {

    val actionList: List<Action> = listOf(
        Action(INVENTORY, R.mipmap.inventory),
        Action(WRITER_TAG, R.mipmap.write),
        Action(FIND_TAG, R.mipmap.find),
        Action(USER, R.mipmap.account),
        Action(SETTINGS, R.mipmap.settings),
        Action(ABOUT, R.mipmap.about),
    )
}