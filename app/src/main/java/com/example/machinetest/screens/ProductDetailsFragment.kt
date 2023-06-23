package com.example.machinetest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.machinetest.databinding.FragmentProductDetailsBinding


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


}