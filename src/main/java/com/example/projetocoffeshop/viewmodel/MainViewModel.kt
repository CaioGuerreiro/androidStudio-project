package com.example.projetocoffeshop.viewmodel

import androidx.lifecycle.LiveData
import com.example.projetocoffeshop.domain.BannerModel
import com.example.projetocoffeshop.domain.CategoryModel
import com.example.projetocoffeshop.domain.ItemsModel
import com.example.projetocoffeshop.repository.MainRepository

class MainViewModel {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }
    fun loadPopular(): LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }
}