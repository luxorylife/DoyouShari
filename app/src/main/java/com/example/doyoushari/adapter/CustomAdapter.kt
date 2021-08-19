package com.example.doyoushari.adapter

import android.content.Context
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(context: Context) : RecyclerView(context) {

    override fun onInterceptHoverEvent(event: MotionEvent?): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        return false
    }
}