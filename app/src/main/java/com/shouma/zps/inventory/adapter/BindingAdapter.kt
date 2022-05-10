package com.shouma.zps.inventory.adapter

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
@date:2022/5/7
@time:10:05 下午
@author:zhaops
@desc:
 */

@BindingAdapter("imageFromResource")
fun bindImageFromResource(view: ImageView, resourceId: Int) {
    Glide.with(view.context)
        .load(resourceId)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}

@BindingAdapter("isGone")
fun bindVisibility(view: View, isGone: Boolean?) {
    if (isGone == null || isGone) {
        view.visibility = GONE
    } else {
        view.visibility = VISIBLE
    }
}