function filterMovies() {
    const selectedGenre = document.getElementById("genreFilter").value;
    const movies = document.querySelectorAll(".movie-card .card");

    movies.forEach(movie => {
      if (selectedGenre === "all" || movie.getAttribute("data-genre") === selectedGenre) {
        movie.style.display = "block";
      } else {
        movie.style.display = "none";
      }
    });
  }