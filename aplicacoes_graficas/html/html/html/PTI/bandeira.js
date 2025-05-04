window.onload = function() {
   
    let canvas = document.getElementById("myCanvas");
    let ctx = canvas.getContext("2d");

    
    canvas.width = 200;
    canvas.height = 100;

    
    ctx.fillStyle = "#FFFFFF"; 
    ctx.fillRect(0, 0, canvas.width, canvas.height);

   
    ctx.strokeStyle = "#000000";
    ctx.lineWidth = 2;
    ctx.strokeRect(0, 0, canvas.width, canvas.height);

   
    let centerX = canvas.width / 2;
    let centerY = canvas.height / 2;
    let radius = 30;

    ctx.beginPath();
    ctx.arc(centerX, centerY, radius, 0, 2 * Math.PI);
    ctx.fillStyle = "#BC002D"; 
    ctx.fill();
    ctx.closePath();

    let img = document.querySelector('section img');
    img.style.width = '200px';  
    img.style.height = '100px'; 
};

