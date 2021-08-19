package com.example.doyoushari.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.doyoushari.databinding.ItemCardBinding
import com.example.doyoushari.entites.Card

class CardAdapter(private val cards: List<Card>): RecyclerView.Adapter<CardViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder =
        CardViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount(): Int {
        return cards.count()
    }

}