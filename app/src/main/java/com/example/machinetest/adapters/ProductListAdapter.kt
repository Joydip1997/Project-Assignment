package com.example.machinetest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.machinetest.data.model.Product
import com.example.machinetest.databinding.ItemProductBinding

class ProductListAdapter() :
    RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private var _productList : ArrayList<Product> = ArrayList()
    private var onProductClick: ((String) -> Unit)? = null

    fun setProductList(productList: ArrayList<Product>){
        _productList = productList
        notifyDataSetChanged()
    }

    fun setOnProductItemClickListener(onProductClick : (productId : String) -> Unit){
        this.onProductClick = onProductClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(_productList[position])
    }

    override fun getItemCount(): Int {
        return _productList.size
    }

    inner class ProductListViewHolder(private val binding : ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.apply {
                imageView.setImageResource(product.productImages.first())
                tvTitle.text = product.productTitle
                tvDescription.text = product.productDescription
                tvMpr.text = product.productPrice.toString()
                root.setOnClickListener { onProductClick?.let { it1 -> it1(product.id) } }
            }
        }
    }
}
