package com.example.recylerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recylerviewexample.Models.BlogPost
import com.example.recylerviewexample.BlogRecyclerAdapter
import com.example.recylerviewexample.DataSource
import com.example.recylerviewexample.R
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private lateinit var blogAdapter: BlogRecyclerAdapter
// this means it's not nullable but will be initialised very soon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }


    private fun addDataSet() {
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
        }
//            val topSpacingDecorate = TopSpacingItemDecoration(30)
//            addItemDecoration(topSpacingDecorator)
    }
}