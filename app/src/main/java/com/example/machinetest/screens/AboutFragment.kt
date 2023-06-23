package com.example.machinetest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.machinetest.MainActivity
import com.example.machinetest.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {
    private var _binding : FragmentAboutBinding?= null
    private val binding : FragmentAboutBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentAboutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tv.setOnClickListener {  }
    }


}