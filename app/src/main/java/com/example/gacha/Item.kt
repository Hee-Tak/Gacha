package com.example.gacha

class Item(val name: String, val type: String, val grade: String, var quantity: Int) {
    override fun toString(): String {
        return "$name [$type, $grade] : $quantity"
    }
}

//이름, 종류, 등급, 수량
