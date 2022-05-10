package com.shouma.zps.inventory.base

import android.app.Application
import com.shouma.zps.inventory.BuildConfig
import com.shouma.zps.inventory.data.AppDatabase
import com.shouma.zps.inventory.repository.InventoryRepository
import com.shouma.zps.inventory.repository.UserRepository
import com.shouma.zps.inventory.vm.*
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

/**
@date:2022/4/26
@time:7:23 下午
@author:zhaops
@desc:
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        MMKV.initialize(this)
        startKoin {
            androidContext(this@BaseApplication)
            modules(viewModelModule)
        }
    }
}

val viewModelModule = module {
    single { MMKV.defaultMMKV() }
    single { AppDatabase.getInstance(androidApplication()).userDao() }
    single { InventoryRepository(get()) }
    single { UserRepository(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { BatchViewModel(get()) }
    viewModel { ScanViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { UhfViewModel(get()) }
    viewModel { ConditionViewModel(get()) }
}