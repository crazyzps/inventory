package com.shouma.zps.inventory.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.rscja.deviceapi.RFIDWithUHFUART
import com.shouma.zps.inventory.R
import com.shouma.zps.inventory.utilities.*
import timber.log.Timber

class WorkActivity : AppCompatActivity() {

    lateinit var brAction: String
    lateinit var brExtraKey: String
    lateinit var brCategory: String

    lateinit var chainwayUhf: RFIDWithUHFUART

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        initPda()
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host).navigateUp()

    private fun initPda() {
        when (Build.BRAND) {
            CHAINWAY -> {
                brAction = "com.scanner.broadcast"
                brExtraKey = "data"
                chainwayUhf = RFIDWithUHFUART.getInstance()
                Thread {
                    if (chainwayUhf.init()) {
                        Timber.d("success")
                    }
                }.start()
            }
            HONEYWELL -> {
                brAction = "com.honeywell.android.scan"
                brExtraKey = "data"
            }
            IDATA -> {
                brAction = "android.intent.action.SCANRESULT"
                brExtraKey = "value"
            }
            NEWLAND -> {
                brAction = "nlscan.action.SCANNER_RESULT"
                brExtraKey = "SCAN_BARCODE1"
            }
            UROVO -> {
                brAction = "android.intent.ACTION_DECODE_DATA"
                brExtraKey = "barcode_string"
            }
            ZEBRA -> {
                brAction = "android.intent.action.DEFAULT"
                brCategory = "android.intent.category.MAIN"
            }
            else -> {
                brAction = "shouma"
                brExtraKey = "data"
            }
        }
    }
}