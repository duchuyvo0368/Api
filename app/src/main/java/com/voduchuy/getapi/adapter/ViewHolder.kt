package com.voduchuy.getapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.voduchuy.getapi.R
import com.voduchuy.getapi.databinding.ItemViewBinding
import com.voduchuy.getapi.model.UsersItem

class ViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val binding =
                ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }
    }

    fun bind(user: UsersItem) {
        binding.tvName.text = user.name
        binding.tvUrl.text = user.email
//        Glide.with(binding.root).load(user.avatar_url)
//            .error(R.mipmap.ic_launcher).into(binding.profileImage)

        /*
        -Glide.with():co the truyen vao activity,fragment,context,view
        -load() download anh bang url truyen vao
        -override() kich thuc anh
        -error() neu anh mo thi su dung (R.mipmap.ic_launcher)
        -into() setter() anh
        */
    }
}