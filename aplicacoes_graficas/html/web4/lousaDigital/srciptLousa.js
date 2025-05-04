const canvas = document.querySelector("#canvas")
const ctx = canvas.getContext("2d")

canvas.height = window.innerHeight
canvas.width = window.innerWidth

ctx.strokeStyle = "white"

let painting = false;

canvas.addEventListener('mousedown', () => painting = true)
canvas.addEventListener('mouseup', () => {
    painting = false
    ctx.beginPath()
})

canvas.addEventListener('mousemove', (e) => {
    if (!painting) return
    ctx.lineTo(e.clientX, e.clientY)
    ctx.stroke()
    ctx.beginPath()
    ctx.moveTo(e.clientX, e.clientY)
    ctx.closePath()
})

document.querySelector("#red").addEventListener('click', () => ctx.strokeStyle = "red"
)
document.querySelector("#yellow").addEventListener('click', () => ctx.strokeStyle = "yellow"
)
document.querySelector("#blue").addEventListener('click', () => ctx.strokeStyle = "blue"
)
document.querySelector("#white").addEventListener('click', () => ctx.strokeStyle = "white"
)

document.querySelector("#line1").addEventListener('click', () => ctx.lineWidth = 1
)
document.querySelector("#line5").addEventListener('click', () => ctx.lineWidth = 5
)
document.querySelector("#line10").addEventListener('click', () => ctx.lineWidth = 10
)

document.querySelector("#erase").addEventListener('click', () => ctx.clearRect(0, 0, canvas.width, canvas.height)
)


