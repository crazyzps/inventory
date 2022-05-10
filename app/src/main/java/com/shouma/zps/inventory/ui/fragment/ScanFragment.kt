package com.shouma.zps.inventory.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shouma.zps.inventory.databinding.FragmentScanBinding

/**
@date:2022/5/8
@time:3:54 下午
@author:zhaops
@desc:
 */
class ScanFragment : Fragment() {

    private lateinit var binding: FragmentScanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}