package com.shouma.zps.inventory.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shouma.zps.inventory.databinding.ActivityLoginBinding
import com.shouma.zps.inventory.vm.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initView()
    }

    private fun initView() {
        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, WorkActivity::class.java))
        }
    }

}