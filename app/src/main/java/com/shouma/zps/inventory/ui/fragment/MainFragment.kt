package com.shouma.zps.inventory.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.shouma.zps.inventory.R
import com.shouma.zps.inventory.adapter.ActionAdapter
import com.shouma.zps.inventory.databinding.FragmentMainBinding
import com.shouma.zps.inventory.vm.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
@date:2022/5/7
@time:7:15 下午
@author:zhaops
@desc:
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val adapter = ActionAdapter()
        binding.mainActionList.adapter = adapter
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: ActionAdapter, binding: FragmentMainBinding) {
        adapter.submitList(viewModel.actionList)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_upload -> Toast.makeText(activity, "upload", Toast.LENGTH_SHORT).show()
            R.id.menu_delete -> Toast.makeText(activity, "delete", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}