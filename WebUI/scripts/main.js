var signIn = document.getElementById("sign-in"),
    signUp = document.getElementById("sign-up"),
    closeIn = document.getElementById("close-in"),
    closeUp = document.getElementById("close-up"),
    inForm = document.getElementById("in-form"),
    upForm = document.getElementById("up-form"),
    buttonName;

signIn.addEventListener("click", openForm);
signUp.addEventListener("click", openForm);
closeIn.addEventListener("click", closeForm);
closeUp.addEventListener("click", closeForm);

function openForm() {
    buttonName = this.innerHTML;
    switch(buttonName) {
        case "Connexion":
            inForm.style.zIndex = "2";
            inForm.style.opacity = "1";
            inForm.style.transform = "translate(-50%, -50%)";
            break;
        case "Inscription":
            upForm.style.zIndex = "2";
            upForm.style.opacity = "1";
            upForm.style.transform = "translate(-50%, -50%)";
            break;
    }
}
function closeForm() {
    buttonName = this.id;
    switch(buttonName) {
        case "close-in":
            inForm.style.zIndex = "-2";
            inForm.style.opacity = "0";
            inForm.style.transform = "translate(-50%, -25%)";
            break;
        case "close-up":
            upForm.style.zIndex = "-2";
            upForm.style.opacity = "0";
            upForm.style.transform = "translate(-50%, -25%)";
            break;
    }
}