package com.example.a2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ApartmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_apartment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Populate linear layout with data
        val listings = listOf<Listing>(
            Listing("123 Main St", "$200,000", R.drawable.homepl),
            Listing("456 Elm St", "$180,000", R.drawable.homepl),
            Listing("789 Oak St", "$220,000", R.drawable.homepl)
        )
        val linearLayoutHomes = findViewById<LinearLayout>(R.id.llApt)

        for (listing in listings) {
            val view = LayoutInflater.from(this).inflate(R.layout.item_home, linearLayoutHomes, false)

            val checkBox = view.findViewById<CheckBox>(R.id.checkBox)
            val imageView = view.findViewById<ImageView>(R.id.ivHome)
            val tvAddress = view.findViewById<TextView>(R.id.tvAddress)
            val tvPrice = view.findViewById<TextView>(R.id.tvPrice)

            imageView.setImageResource(listing.image)
            tvAddress.text = listing.title
            tvPrice.text = listing.price

            linearLayoutHomes.addView(view)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miHome -> {
                startActivity(Intent(this, DetachedHouseActivity::class.java))
            }
            R.id.miSemiHome -> {
                startActivity(Intent(this, SemiDetachedActivity::class.java))
            }
            R.id.miCondo -> {
                startActivity(Intent(this, CondoActivity::class.java))
            }
            R.id.miApt -> {
                startActivity(Intent(this, ApartmentActivity::class.java))
            }
            R.id.miTownHome -> {
                startActivity(Intent(this, TownHouseActivity::class.java))
            }
        }
        return true
    }
}