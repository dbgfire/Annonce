var content = document.getElementById("content"),
    login = document.getElementById("login"),
    subscribe = document.getElementById("subscribe"),
    header = document.getElementsByTagName("header")[0],
    textWelcome = document.getElementById("textWelcome"),
    blurBackground = document.getElementById("blurBackground");

content.style.opacity = 0;

login.addEventListener("click", showContent);
subscribe.addEventListener("click", showContent);

function showContent() {
    content.style.transition = "all 0.25s";
    header.style.transition = "all 0.25s";
    textWelcome.style.transition = "all 0.15s";
    header.style.opacity = "0";
    textWelcome.style.opacity = "0";
    blurBackground.style.opacity = "1";
    content.style.height = "80vh";
    content.style.opacity = "1";
    content.style.zIndex = "2";
}
function closeContent() {
    content.style.height = "0";
    content.style.opacity = "0";
    blurBackground.style.opacity = "0";
    header.style.opacity = "1";
    textWelcome.style.opacity = "1";
    content.style.zIndex = "-1";
}