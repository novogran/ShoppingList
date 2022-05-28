package com.example.shoppinglist.domain

data class ShopItem(
    var name: String,
    var count: Int,
    var checked: Boolean,
    var id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID: Int = -1
    }
}
