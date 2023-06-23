package com.example.machinetest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.machinetest.MainActivity
import com.example.machinetest.adapters.ProductListAdapter
import com.example.machinetest.data.model.productList
import com.example.machinetest.databinding.FragmentProductListBinding
import com.example.machinetest.utils.collectIn
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private var _binding : FragmentProductListBinding?= null
    private val binding : FragmentProductListBinding get() = _binding!!

    private val productListAdapter = ProductListAdapter()

    private val viewModel : ProductListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentProductListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = productListAdapter
        productListAdapter.setProductList(productList = productList)
        productListAdapter.setOnProductItemClickListener {productId->
            (requireActivity() as MainActivity).navigateToProductDetails(productId)
        }

        viewModel.apply {
            fetchProducts()
            productList.collectIn(viewLifecycleOwner){productList->
                productListAdapter.setProductList(productList)
            }
        }
    }




}