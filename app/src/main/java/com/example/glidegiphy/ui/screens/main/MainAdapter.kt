package com.example.glidegiphy.ui.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.glidegiphy.R
import com.example.glidegiphy.data.remote.ResponseGif.Data
import com.example.glidegiphy.data.remote.ResponseGif.GifDetailsData
import com.example.glidegiphy.databinding.GifItemBinding

class MainAdapter : ListAdapter<Data, MainAdapter.GifHolder>(ItemComparator()) {

    class ItemComparator : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(
            oldItem: Data,
            newItem: Data
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Data,
            newItem: Data
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    inner class GifHolder(private val binding: GifItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data) = with(binding) {

            val currentGif = item.images.original.url

            Glide.with(binding.root)
                .asGif()
                .placeholder(R.drawable.rectangle_grey)
                .error(R.drawable.ic_error_outline)
                .load(currentGif)
                .into(gifItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GifHolder(
            GifItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: GifHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            val detailsData = GifDetailsData(currentItem.title, currentItem.import_datetime, currentItem.id)
            val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(detailsData)
            holder.itemView.findNavController().navigate(action)
        }
    }
}