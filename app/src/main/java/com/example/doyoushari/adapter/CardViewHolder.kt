package com.example.doyoushari.adapter


import androidx.recyclerview.widget.RecyclerView
import com.example.doyoushari.R
import com.example.doyoushari.databinding.ItemCardBinding
import com.example.doyoushari.entites.Card

class CardViewHolder(private val binding: ItemCardBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(card: Card){
        binding.text.text = card.text
        binding.text.setBackgroundResource(when(card.trueColor){
            "Красный" -> R.color.red
            "Зеленый" -> R.color.green
            "Синий" -> R.color.blue
            "Желтый" -> R.color.yellow
            "Оранжевый" -> R.color.orange
            else -> R.color.black
        })
    }

}