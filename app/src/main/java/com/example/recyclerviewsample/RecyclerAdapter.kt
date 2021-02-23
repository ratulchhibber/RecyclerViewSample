package com.example.recyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter(private var movieList: ArrayList<Movie>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val view = layoutInflator.inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                //   val snack = "Item position clicked: $adapterPosition"
                Snackbar
                        .make(itemView,
                                "Sample snack bar message",
                                Snackbar.LENGTH_INDEFINITE)
                        .setAction("Click Me") {
                            Snackbar
                                    .make(itemView,
                                            "You clicked the button on snack bar",
                                            Snackbar.LENGTH_SHORT).show()
                        }.show()
            }
        }

        fun bind(movie: Movie) {
            itemView.movieNameTextView.text = movie.name
            itemView.ratingTextView.text = movie.rating.toString()
        }
    }
}