package com.example.doyoushari.domain

import com.example.doyoushari.entites.Card
import java.util.*

object Generator {

    private val colors = listOf(
        "Красный",
        "Желтый",
        "Синий",
        "Зеленый",
        "Оранжевый"
    )

    fun generateCards(): MutableList<Card>{
        var cards = mutableListOf<Card>()

        var random = Random()

        for (index in 0..999){
            cards.add(Card(colors[random.nextInt(5)], colors[random.nextInt(5)]))
        }

        return cards
    }

}