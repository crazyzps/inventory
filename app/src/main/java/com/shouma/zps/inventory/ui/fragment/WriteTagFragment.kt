package com.shouma.zps.inventory.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shouma.zps.inventory.databinding.FragmentWriteTagBinding

/**
@date:2022/5/8
@time:3:07 下午
@author:zhaops
@desc:
 */
class WriteTagFragment : Fragment() {

    private lateinit var binding: FragmentWriteTagBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteTagBinding.inflate(inflater, container, false)
        binding.lifecycleOwner =viewLifecycleOwner
        return binding.root
    }
}