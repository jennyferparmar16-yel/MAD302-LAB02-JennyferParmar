/*
 * Course Code: MAD302
 * Lab Number : 2
 * Name: Jennyfer Rajubhai Parmar
 * Student ID: A00201240
 * Date of Submission: 2026-04-12
 * Description:
 * This activity displays a list of products using a RecyclerView.
 * Users can select a product from the list, and the app navigates
 * to the DetailActivity while passing the selected product data.
 */

package com.example.lab2_jennyfer

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerProducts)

        //List of products
        val products = listOf(
            Product("Laptop", 999.99, "High performance laptop"),
            Product("Headphones", 199.99, "Noise cancelling headphones"),
            Product("Keyboard", 49.99, "Mechanical keyboard"),
            Product("Mouse", 29.99, "Wireless mouse"),
            Product("Monitor", 249.99, "27-inch HD monitor"),
            Product("USB Drive", 19.99, "64GB USB 3.0 flash drive")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = ProductAdapter(products) { product ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", product.name)//Passing name
            intent.putExtra("price", product.price)//passing price
            intent.putExtra("description", product.description)//passing description
            startActivity(intent)
        }
    }
}