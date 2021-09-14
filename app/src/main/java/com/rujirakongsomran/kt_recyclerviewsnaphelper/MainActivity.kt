package com.rujirakongsomran.kt_recyclerviewsnaphelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.rujirakongsomran.kt_recyclerviewsnaphelper.adapter.ExampleAdapter
import com.rujirakongsomran.kt_recyclerviewsnaphelper.databinding.ActivityMainBinding
import com.rujirakongsomran.kt_recyclerviewsnaphelper.model.ExampleItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val exampleList = generateDummyList(500)
        binding.recyclerView.adapter = ExampleAdapter(exampleList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerView)
        binding.recyclerView.setHasFixedSize(true)

    }

    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }

            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}