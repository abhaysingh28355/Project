const joinele = document.getElementById("join-form");
const togglebutton = document.getElementsByClassName("togglebutton")[0];
const navbarlinks = document.getElementsByClassName("navbarlinks")[0];



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