document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("loginForm");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Impede o envio do formulário

        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();

        console.log("Verificando login...");

        if (email !== "usuario@teste.com" || password !== "123456") {
            form.classList.add("erro"); // Adiciona a classe de erro (balanço)

            setTimeout(() => {
                form.classList.remove("erro"); // Remove a classe após a animação
            }, 300);
        } else {
            alert("Login bem-sucedido!");
        }
    });
});
