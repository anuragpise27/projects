document.getElementById("playTrailer").addEventListener("click", function() {
    document.getElementById("trailerModal").style.display = "block";
    document.getElementById("trailerVideo").play();
  });

  document.querySelector(".close-modal").addEventListener("click", function() {
    document.getElementById("trailerModal").style.display = "none";
    document.getElementById("trailerVideo").pause();
  });

  window.addEventListener("click", function(event) {
    let modal = document.getElementById("trailerModal");
    if (event.target === modal) {
      modal.style.display = "none";
      document.getElementById("trailerVideo").pause();
    }
  });