function searchMovies() {
  const query = document.getElementById('search-bar').value.toLowerCase();
  const movies = document.querySelectorAll('.card');
  let found = false;

  movies.forEach(movie => {
    const title = movie.querySelector('h4').textContent.toLowerCase();
    if (title.includes(query)) {
      movie.style.display = 'block';
      found = true;
    } else {
      movie.style.display = 'none';
    }
  });

  const container = document.getElementById('top-movie same'); // Ensure this ID exists
  if (container) {
    container.style.display = found ? 'none' : 'block';
  }
}

document.getElementById('search-bar').addEventListener('keydown', function(event) {
  if (event.key === 'Enter') {
    searchMovies();
  }
});