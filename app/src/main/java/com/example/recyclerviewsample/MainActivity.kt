package com.example.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            adapter = RecyclerAdapter(Movie.movies())
            addItemDecoration(
                DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL)
            )
            setHasFixedSize(true)
        }
    }
}