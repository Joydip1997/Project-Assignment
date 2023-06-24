package com.example.machinetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.machinetest.databinding.FragmentBottomNavigationBinding

class BottomNavigationFragment : Fragment() {
    private var _binding : FragmentBottomNavigationBinding ?= null
    private val binding : FragmentBottomNavigationBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentBottomNavigationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)
        binding.navigation.setupWithNavController(navController)
        binding.bottomNavigation.itemIconTintList = null
        binding.bottomNavigation.itemActiveIndicatorColor = null
        binding.navigation.itemIconTintList = null


    }


    fun openDrawer() {
        binding.myDrawerLayout.openDrawer(GravityCompat.START)
    }


}