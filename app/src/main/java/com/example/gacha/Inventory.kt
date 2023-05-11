package com.example.gacha

import com.google.android.material.color.utilities.QuantizerMap

class Inventory {
    val items = mutableListOf<Item>()

    fun addItem(item: Item){
        val index = items.indexOfFirst { it.name == item.name && it.type == item.type && it.grade == item.grade}
        if(index >= 0){
            items[index].quantity += item.quantity
        } else {
            items.add(item)
        }
    }

    fun removeItem(item: Item) {
        val index = items.indexOfFirst { it.name == item.name && it.type == item.type && it.grade == item.grade}
        if(index >= 0){
            items[index].quantity -= item.quantity
            if(items[index].quantity <= 0){
                items.removeAt(index)
            }
        }
    }

    fun updateItemQuantity(item: Item, quantity: Int){
        val index = items.indexOfFirst { it.name == item.name && it.type == item.type && it.grade == item.grade}
        if(index >= 0){
            items[index].quantity = quantity
            if(items[index].quantity <= 0){
                items.removeAt(index)
            }
        }
    }



}