package com.example.machinetest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.machinetest.adapters.ProductImageViewPagerAdapter
import com.example.machinetest.data.model.productList
import com.example.machinetest.databinding.FragmentProductDetailsBinding
import com.google.android.material.tabs.TabLayoutMediator


class ProductDetailsFragment : Fragment() {
    private var _binding : FragmentProductDetailsBinding?= null
    private val binding : FragmentProductDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ProductImageViewPagerAdapter()
        binding.viewPager.adapter = adapter
        adapter.setImageList(productList.first().productImages)
        TabLayoutMediator(binding.intoTabLayout, binding.viewPager)
        { tab, position ->}.attach()
    }


}