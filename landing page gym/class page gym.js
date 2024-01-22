const joinele = document.getElementById("join-form");
const togglebutton = document.getElementsByClassName("togglebutton")[0];
const navbarlinks = document.getElementsByClassName("navbarlinks")[0];



let slideIndex = 0;
showSlides();

function showSlides() {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}
  slides[slideIndex-1].style.display = "block";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}


function togglefunction() {
  navbarlinks.classList.toggle("show")
}



function joinForm() {
joinele.style.display = "block";
}



function buybutton() {
alert("Payment Successfull");
joinele.style.display = "none";
}

function crossmark() {
joinele.style.display = "none";
}