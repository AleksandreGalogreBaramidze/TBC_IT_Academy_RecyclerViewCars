package com.example.recyclerviewapplication

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapplication.databinding.RecyclerviewLayoutBinding

class RecyclerViewAdapter(private val viewItems: MutableList<Items>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var itemView = RecyclerviewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ItemViewHolder(itemView)
        return holder
    }
    inner class ItemViewHolder(val binding: RecyclerviewLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val model = viewItems[adapterPosition]
            binding.carView.setImageResource(model.car)
            binding.SpeedView.text = model.speed
            binding.typeView.text = model.type
            binding.engineView.setImageResource(model.engine)
        }
    }
    override fun getItemCount(): Int = viewItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        holder.bind()
    }


}