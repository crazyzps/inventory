package com.shouma.zps.inventory.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shouma.zps.inventory.databinding.FragmentBatchBinding
import com.shouma.zps.inventory.vm.BatchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
@date:2022/5/8
@time:3:51 下午
@author:zhaops
@desc:
 */
class BatchFragment : Fragment() {

    lateinit var binding: FragmentBatchBinding

    private val viewModel: BatchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBatchBinding.inflate(inflater, container, false)
        val path = activity?.getExternalFilesDir("db")!!.path
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}