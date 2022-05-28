package com.example.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

class MainViewModel: ViewModel(){

    private val repository = ShopListRepositoryImpl

    private val getShopList = GetShopList(repository)
    private val deleteShopItem = DeleteShopItem(repository)
    private val editShopItem = EditShopItem(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList(){
        val list = getShopList.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItem.deleteShopItem(shopItem)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem){
        val item = shopItem.copy(enabled = !shopItem.enabled)
        editShopItem.editShopItem(item)
        getShopList()
    }

    fun editShopItem(shopItem: ShopItem){
        editShopItem.editShopItem(shopItem)
        getShopList()
    }

}