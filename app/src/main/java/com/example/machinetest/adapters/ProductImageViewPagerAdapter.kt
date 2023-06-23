package com.example.machinetest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.machinetest.databinding.ItemImageBinding
import com.example.machinetest.databinding.ItemProductBinding

class ProductImageViewPagerAdapter() :
    RecyclerView.Adapter<ProductImageViewPagerAdapter.ImageViewHolder>() {

    private var _imageList: ArrayList<Int> = ArrayList()

    fun setImageList(imageList : ArrayList<Int>){
        _imageList = imageList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return  ImageViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(_imageList[position])
    }

    override fun getItemCount(): Int {
        return _imageList.size
    }

    inner class ImageViewHolder(private val binding : ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(image : Int){
           binding.imageView.setImageResource(image)
       }
    }
}