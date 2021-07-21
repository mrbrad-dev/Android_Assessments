package com.akp.my_students_app.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noahgreenmusic.my_students_app.databinding.ItemsListBinding
import com.akp.my_students_app.models.Items

class ItemAdapter(var items: List<Items>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemsListBinding) : RecyclerView.ViewHolder(binding.root){

        fun views(item: Items){
            binding.apply {
                itemId.text = item.id.toString()
                itemName.text = item.name
                itemPrice.text = item.price.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemsListBinding = ItemsListBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
     holder.views(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}