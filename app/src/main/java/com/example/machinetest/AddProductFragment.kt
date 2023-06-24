package com.example.machinetest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.machinetest.data.model.Product
import com.example.machinetest.data.model.productImageList
import com.example.machinetest.databinding.FragmentAddProductBinding
import com.example.machinetest.utils.collectIn
import com.example.machinetest.utils.toSafeFloat
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class AddProductFragment : Fragment() {
    private var _binding : FragmentAddProductBinding?= null
    private val binding : FragmentAddProductBinding get() = _binding!!

    private val viewModel : AddProductViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentAddProductBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isProductAdded.collectIn(viewLifecycleOwner){isSuccessfull->
            if(isSuccessfull){
                findNavController().navigate(R.id.bottomNavigationFragment)
            }else{
                Toast.makeText(requireContext(),"Please enter all the fields",Toast.LENGTH_SHORT).show()
            }
        }

        binding.apply {
            buttonAddProduct.setOnClickListener {
                val productTitle = binding.editTextProductTitle.text.toString()
                val productDescription= binding.editTextProductDescription.text.toString()
                val productMrp= binding.editTextProductPrice.text.toString().toSafeFloat()
                val productManufacturer = binding.editTextProductManufacturer.text.toString()
                val productModel = binding.editTextProductModel.text.toString()
                val productPartNo = binding.editTextProductPartNo.text.toString()
                val randomIndex = Random.nextInt(4)
                Product(
                    productImages = productImageList[randomIndex],
                    productTitle = productTitle,
                    productDescription = productDescription,
                    productPrice = productMrp,
                    productManufacturer = productManufacturer,
                    productPartModel = productModel,
                    productPartNumber = productPartNo
                ).apply {
                    viewModel.addNewProduct(this)
                }
            }
            buttonGoToProductList.setOnClickListener { findNavController().navigate(R.id.bottomNavigationFragment) }
        }

    }






}