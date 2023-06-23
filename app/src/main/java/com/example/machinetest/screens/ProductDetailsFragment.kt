package com.example.machinetest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.machinetest.adapters.ProductImageViewPagerAdapter
import com.example.machinetest.data.model.productList
import com.example.machinetest.databinding.FragmentProductDetailsBinding
import com.example.machinetest.utils.collectIn
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    private var _binding : FragmentProductDetailsBinding?= null
    private val binding : FragmentProductDetailsBinding get() = _binding!!

    private val viewModel : ProductDetailsViewModel by viewModels()

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
        val productId = requireArguments().getInt("PRODUCT_ID",0)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.intoTabLayout, binding.viewPager)
        { tab, position ->}.attach()

        viewModel.apply {
            getProductDetailsById(productId)
            productDetails.collectIn(viewLifecycleOwner){product->
                product?.let {
                    adapter.setImageList(it.productImages)
                    binding.apply {
                        tvProductManuValue.text = it.productManufacturer
                        tvProductModelValue.text = it.productPartModel
                        tvProductPartNoValue.text = it.productPartNumber
                        tvProductDescriptionValue.text = it.productDescription
                        tvMrp.text = it.productPrice.toString()
                    }
                }

            }
        }
    }


}