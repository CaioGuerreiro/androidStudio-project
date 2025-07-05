package com.example.projetocoffeshop.adapter

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetocoffeshop.R
import com.example.projetocoffeshop.databinding.ViewholdercategoryBinding
import com.example.projetocoffeshop.domain.CategoryModel

class CategoryAdapter(val items: MutableList<CategoryModel>):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){

    private lateinit var context: Context
    private var selectedPosition=-1
    private var lastSelectedPosition=-1

    inner class ViewHolder (val binding: ViewholdercategoryBinding):
            RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholdercategoryBinding.inflate(LayoutInflater.from(context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.titleCat.text = item.title

        holder.binding.root.setOnClickListener{
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

           Handler(Looper.getMainLooper()).postDelayed({

           },500)
        }
        if(selectedPosition == position){
            holder.binding.titleCat.setBackgroundResource(R.drawable.brown_full_corner_bg)
            holder.binding.titleCat.setTextColor(context.resources.getColor(R.color.white))
        }else{
            holder.binding.titleCat.setBackgroundResource(R.drawable.white_full_corner_bg)
            holder.binding.titleCat.setTextColor(context.resources.getColor(R.color.darkBrown))
        }
    }

    override fun getItemCount(): Int = items.size

}