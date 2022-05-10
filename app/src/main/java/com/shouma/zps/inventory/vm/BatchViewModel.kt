package com.shouma.zps.inventory.vm

import android.content.Context
import android.text.SpannableString
import androidx.lifecycle.ViewModel
import androidx.sqlite.db.SimpleSQLiteQuery
import com.shouma.zps.inventory.data.entity.Batch
import com.shouma.zps.inventory.repository.InventoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber
import java.io.File

/**
@date:2022/4/28
@time:11:53 上午
@author:zhaops
@desc:
 */
class BatchViewModel(private val repo: InventoryRepository) : ViewModel() {

    lateinit var spannableString: SpannableString


    init {
        spannableString = SpannableString.valueOf("")
    }

    fun openDb(context: Context, file: File) {
        repo.openDb(context, file)
    }


    suspend fun getAssets() {

        Thread {
            val cursor = repo.getAssets(SimpleSQLiteQuery("SELECT * FROM Asset "))
            val list = ArrayList<List<String?>>()
            while (cursor.moveToNext()) {
                val assets = ArrayList<String?>()
                for (index in 0 until cursor.columnCount) {
                    assets.add(cursor.getString(index))
                }
                list.add(assets)
            }
        }.start()
    }

    suspend fun getBatch() {
        repo.getBatch().flowOn(
            Dispatchers.IO
        ).onStart { Timber.d("processBar start") }
            .onCompletion { Timber.d("processBar end") }
            .catch { exception -> exception.message?.let { Timber.d(it) } }
            .collect {
                Timber.d(it.batchCode)
            }
    }

    fun getB(): Flow<Batch> = repo.getBatch()
}