package com.example.projetocoffeshop.domain

import java.io.Serializable

data class ItemsModel(
    var title : String = "",
    var descripition: String = "",
    var picUrl: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberInCar: Int = 0,
    var extra: String = ""
): Serializable
