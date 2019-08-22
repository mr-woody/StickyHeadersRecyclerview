package com.okay.sampletamplate.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.okay.sampletamplate.sample.ItemGenerator
import com.okay.sampletamplate.sample.R
import com.okay.sampletamplate.sample.SimpleStickyLayoutManager
import com.okay.sampletamplate.sample.adapter.RecyclerAdapter
import com.okay.sticky.StickyLayoutManager
import com.okay.sticky.exposed.StickyHeaderListener
import kotlinx.android.synthetic.main.activity_demo1.*

class Sample1Activity : AppCompatActivity() {

    private var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo1)

        adapter = RecyclerAdapter(ItemGenerator.demoList())

        val layoutManager = SimpleStickyLayoutManager(this, adapter)
        layoutManager.elevateHeaders(false) // Default elevation of 5dp
        // You can also specify a specific dp for elevation
        layoutManager.elevateHeaders(0)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
        layoutManager.setStickyHeaderListener(object : StickyHeaderListener {
            override fun headerAttached(headerView: View, adapterPosition: Int) {
                Log.d("Listener", "Attached with position: $adapterPosition")
                headerView.findViewById<View>(R.id.button1).setOnClickListener {
                    Toast.makeText(this@Sample1Activity, "点击了button1", Toast.LENGTH_SHORT).show()
                }
            }

            override fun headerDetached(headerView: View, adapterPosition: Int) {
                Log.d("Listener", "Detached with position: $adapterPosition")
            }
        })



        findViewById<View>(R.id.visibility_button).setOnClickListener {
            recycler_view.visibility = if (recycler_view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }
    }
}
