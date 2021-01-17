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

        var movieList = arrayListOf<Movie>(
            Movie("Iron Man 11", 7),
            Movie("Superman", 8),
            Movie("King Kong", 1),
            Movie("Kung fu", 6),
            Movie("The Incredibles", 10),
            Movie("Terminator", 1),
            Movie("Iron Man", 7),
            Movie("Superman", 8),
            Movie("King Kong", 1),
            Movie("Kung fu", 6),
            Movie("The Incredibles", 10),
            Movie("Terminator", 1),
            Movie("Iron Man", 7),
            Movie("Superman", 8),
            Movie("King Kong", 1),
            Movie("Kung fu", 6),
            Movie("The Incredibles 99", 10)
        )

        recyclerView.apply {
            adapter = RecyclerAdapter(movieList)
            addItemDecoration(
                DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL)
            )
            setHasFixedSize(true)
        }
    }
}