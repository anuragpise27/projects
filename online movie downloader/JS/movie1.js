document.addEventListener("DOMContentLoaded", function () {
    fetch("http://127.0.0.1:5000/movies")
        .then(response => response.json())
        .then(movies => {
            const movieContainer = document.querySelector(".movies-container");
            movieContainer.innerHTML = "";

            movies.forEach(movie => {
                const movieHTML = `
                    <div class="movie-card">
                        <div class="img" onclick="openTrailer('${movie.trailer_url}')">
                            <img src="${movie.image_url}" alt="${movie.title}">
                            <i class="fa-regular fa-circle-play" style="margin: 10px;"></i>
                        </div>
                        <div class="content">
                            <h4><span>${movie.title}</span></h4>
                            <div class="date-time">
                                <span><i class="fa-solid fa-calendar-days"></i> ${movie.release_year}</span>
                                <span><i class="fa-regular fa-clock"></i> ${movie.duration}</span>
                            </div>
                            <p>${movie.description}</p>
                            <div class="download-btn">
                                <a href="${movie.download_url}" download>Download <i class="fa-solid fa-download"></i></a>
                            </div>
                        </div>
                    </div>
                `;
                movieContainer.innerHTML += movieHTML;
            });
        })
        .catch(error => console.error("Error fetching movies:", error));
});
