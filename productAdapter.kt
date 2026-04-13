/*
 * Course Code: MAD302
 * Lab Number : 2
 * Name: Jennyfer Rajubhai Parmar
 * Student ID: A00201240
 * Date of Submission: 2026-04-12
 * Description:
 * This adapter binds a list of Product objects to a RecyclerView.
 * It is responsible for displaying each product item and handling
 * user click events on the list items.
 */
package com.example.lab2_jennyfer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val products: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    // Holds item view
    inner class ProductViewHolder(val textView: TextView) :
        RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) as TextView // Inflate layout
        return ProductViewHolder(textView)
    }
    // Returns number of items
    override fun getItemCount(): Int = products.size

    // Bind product data
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.textView.text = "${product.name} - $${product.price}"

        // Handle item click
        holder.textView.setOnClickListener {
            onItemClick(product)
        }
    }
}