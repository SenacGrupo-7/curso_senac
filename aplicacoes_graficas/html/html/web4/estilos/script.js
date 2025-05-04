const canvas = document.querySelector("#canvas");
const ctx = canvas.getContext("2d");

canvas.height = window.innerHeight;
canvas.width = window.innerWidth;

ctx.fillRect(10, 10, 50, 50); // Retângulo preto
ctx.fillStyle = "red";
ctx.fillRect(70, 10, 50, 50); // Retângulo vermelho
ctx.strokeStyle = "white"; // Corrigido de 'strokestyle' para 'strokeStyle'
ctx.fillRect(130, 10, 50, 50); // Novo retângulo na posição correta
ctx.lineWidth = 5
ctx.strokeRect(190, 10, 50, 50)


ctx.beginPath()
ctx.moveTo(100, 100)
ctx.lineTo(200, 100)
ctx.closePath()
ctx.stroke()

ctx.beginPath()
ctx.moveTo(150, 100)
ctx.lineTo(150, 200)
ctx.closePath()
ctx.stroke()