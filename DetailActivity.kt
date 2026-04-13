/*
 * Course Code: MAD302
 * Lab Number : 2
 * Name: Jennyfer Rajubhai Parmar
 * Student ID: A00201240
 * Date of Submission: 2026-04-12
 ** Description:
* This activity receives product data from MainActivity using Intent
* and displays the product's name, price, and description on the screen.
 */
package com.example.lab2_jennyfer

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.detailactivity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailRoot)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name") ?: "Unknown"// Get name from Intent
        val price = intent.getDoubleExtra("price", 0.0) // Get price
        val description = intent.getStringExtra("description") ?: "No description " // Get description


        findViewById<TextView>(R.id.productNameTextView).text = name // Set name
        findViewById<TextView>(R.id.productPriceTextView).text = "$%.2f".format(price) // Format price
        findViewById<TextView>(R.id.productdetailsTextView).text = description // Set description
    }
}