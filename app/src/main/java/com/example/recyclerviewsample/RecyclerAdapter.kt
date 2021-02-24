package com.example.recyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter(private var movieList: ArrayList<Movie>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewTypes {
        Horizontal, Vertical
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)

        if (viewType == ViewTypes.Horizontal.ordinal) {
            val view = layoutInflator.inflate(R.layout.recycler_row, parent, false)
            return ViewHolderHorizontal(view)
        }

        //Vertical Layout
        val view = layoutInflator.inflate(R.layout.recycler_row_vertical_elements, parent, false)
        return ViewHolderVertical(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun getItemViewType(position: Int): Int {
        return when(position % 2) {
            0 -> ViewTypes.Horizontal.ordinal
            1 -> ViewTypes.Vertical.ordinal
            else -> { throw IllegalArgumentException("Invalid position") }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = movieList[position]

        if (holder is ViewHolderHorizontal) {
            holder.bind(movie)
        } else if (holder is ViewHolderVertical) {
            holder.bind(movie)
        }
    }

    class ViewHolderHorizontal(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                //   val snack = "Item position clicked: $adapterPosition"
                Snackbar
                        .make(itemView,
                                "Movie name: ${ it.movieNameTextView.text }",
                                Snackbar.LENGTH_INDEFINITE)
                        .setAction("Click Me") {
                            Snackbar
                                    .make(itemView,
                                            "This is an odd numbered cell",
                                            Snackbar.LENGTH_SHORT).show()
                        }.show()
            }
        }

        fun bind(movie: Movie) {
            itemView.movieNameTextView.text = movie.name
            itemView.ratingTextView.text = movie.rating.toString()
        }
    }

    class ViewHolderVertical(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                //   val snack = "Item position clicked: $adapterPosition"
                Snackbar
                        .make(itemView,
                                "Movie name: ${ it.movieNameTextView.text }",
                                Snackbar.LENGTH_INDEFINITE)
                        .setAction("Click Me") {
                            Snackbar
                                    .make(itemView,
                                            "This is an even numbered cell",
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