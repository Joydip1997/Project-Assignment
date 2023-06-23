package com.example.machinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.machinetest.databinding.ActivityMainBinding
import com.example.machinetest.databinding.FragmentAddProductBinding
import com.example.machinetest.utils.collectIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var navController: NavController ?= null
    private var _binding : ActivityMainBinding?= null
    private val binding : ActivityMainBinding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.color_primary_gradient_1)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

    }

    fun openDrawerLayout(){
        binding.drawerLayout.apply {
            openDrawer(GravityCompat.START)
        }
    }

    fun navigateToProductDetails(productId : Int){
        Bundle().apply {
            putInt("PRODUCT_ID",productId)
            navController?.navigate(R.id.productDetailsFragment,this)
        }

    }
}