package com.example.projetocoffeshop.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.projetocoffeshop.R
import com.example.projetocoffeshop.adapter.CategoryAdapter
import com.example.projetocoffeshop.adapter.PopularAdapter
import com.example.projetocoffeshop.databinding.ActivityMainBinding
import com.example.projetocoffeshop.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
        initCategory()
        initPopular()
    }

    private fun initPopular() {
        binding.progressBarPopular.visibility = View.VISIBLE
        viewModel.loadPopular().observeForever{
            binding.recyclerViewPopular.layoutManager = GridLayoutManager(this, 2)
            binding.recyclerViewPopular.adapter = PopularAdapter(it)
            binding.progressBarPopular.visibility = View.GONE
        }
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility = View.VISIBLE
        viewModel.loadCategory().observeForever{
            binding.categoryView.layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL, false
            )
            binding.categoryView.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility = View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE
        viewModel.loadBanner().observeForever{
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
                binding.progressBarBanner.visibility=View.GONE
        }
        viewModel.loadBanner()
    }
}