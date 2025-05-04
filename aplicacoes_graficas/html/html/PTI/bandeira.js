/* Arquivo bandeira.js */
window.onload = function () {
    let canvas = document.getElementById("myCanvas");
    let ctx = canvas.getContext("2d");
    canvas.width = 200;
    canvas.height = 100;
    ctx.fillStyle = "#FFFFFF";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    ctx.strokeStyle = "#000000";
    ctx.strokeRect(0, 0, canvas.width, canvas.height);
    ctx.beginPath();
    ctx.arc(canvas.width / 2, canvas.height / 2, 30, 0, 2 * Math.PI);
    ctx.fillStyle = "#BC002D";
    ctx.fill();
    let img = document.querySelector('section img');
    img.style.width = '200px';
    img.style.height = '100px';
};
