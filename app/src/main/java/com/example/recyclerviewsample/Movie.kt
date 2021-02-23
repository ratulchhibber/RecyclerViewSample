package com.example.recyclerviewsample


interface Mock {
    fun movies(): ArrayList<Movie>
}

data class Movie(
    val name: String,
    val rating: Int
) {
    companion object: Mock {
        override fun movies(): ArrayList<Movie> {
            return arrayListOf(
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
        }
    }


}