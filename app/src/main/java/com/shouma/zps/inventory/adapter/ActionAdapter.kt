package com.shouma.zps.inventory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shouma.zps.inventory.adapter.ActionAdapter.ActionViewHolder
import com.shouma.zps.inventory.data.entity.Action
import com.shouma.zps.inventory.databinding.ItemActionBinding
import com.shouma.zps.inventory.ui.fragment.MainFragmentDirections
import com.shouma.zps.inventory.utilities.*

/**
@date:2022/5/7
@time:4:58 下午
@author:zhaops
@desc:
 */
class ActionAdapter : ListAdapter<Action, ActionViewHolder>(ActionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolder {
        return ActionViewHolder(
            ItemActionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
        val action = getItem(position)
        holder.bind(action)
    }

    inner class ActionViewHolder(val binding: ItemActionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.action?.let { action ->
                    navigateTo(action, it)
                }
            }
        }

        private fun navigateTo(action: Action, view: View) {
            val direction =
                when (action.name) {
                    INVENTORY -> MainFragmentDirections.actionMainFragmentToBatchFragment()
                    WRITER_TAG -> MainFragmentDirections.actionMainFragmentToWriteTagFragment()
                    FIND_TAG -> MainFragmentDirections.actionMainFragmentToFindTagFragment()
                    USER -> MainFragmentDirections.actionMainFragmentToUserFragment()
                    SETTINGS -> MainFragmentDirections.actionMainFragmentToSettingsFragment()
                    else -> MainFragmentDirections.actionMainFragmentToAboutFragment()
                }
            view.findNavController().navigate(direction)
        }


        fun bind(item: Action) {
            binding.apply {
                action = item
                executePendingBindings()
            }
        }
    }
}

private class ActionDiffCallback : DiffUtil.ItemCallback<Action>() {
    override fun areItemsTheSame(oldItem: Action, newItem: Action): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Action, newItem: Action): Boolean {
        return oldItem == newItem
    }

}