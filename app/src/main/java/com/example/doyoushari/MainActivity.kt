package com.example.doyoushari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doyoushari.adapter.CardAdapter
import com.example.doyoushari.databinding.ActivityMainBinding
import com.example.doyoushari.domain.Generator
import androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags

class MainActivity : AppCompatActivity() {

    val easySpeed = 2000f
    val middleSpeed = 1500f
    val fastSpeed = 1000f

    lateinit var binding: ActivityMainBinding
    var list = Generator.generateCards()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Game"

        var layout = CustomManager(this, LinearLayoutManager.VERTICAL, true, easySpeed)
        binding.recycler.layoutManager = layout
        binding.recycler.adapter = CardAdapter(list)

        val touchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback(){
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                list.removeAt(viewHolder.adapterPosition)
                binding.recycler.adapter!!.notifyItemRemoved(viewHolder.adapterPosition)
            }

        })

        touchHelper.attachToRecyclerView(binding.recycler)

        binding.recycler.layoutManager!!.smoothScrollToPosition(binding.recycler, RecyclerView.State(), list.count()-1)

    }
}

