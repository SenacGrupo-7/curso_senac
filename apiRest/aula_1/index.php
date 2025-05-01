<?php
// Obtém o valor do CEP enviado por GET, ou define como string vazia se não houver
$cep = $_GET['cep'] ?? '';
?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <title>Consulta CEP - ViaCEP</title>

    <script>
    // Função para buscar o endereço com base no CEP digitado
    function buscarCEP() {
        var cep = document.getElementById("cep").value;
        if (!cep) return;

        var request = new XMLHttpRequest();
        request.open('GET', 'https://viacep.com.br/ws/' + cep + '/json/', true);

        request.onload = function() {
            var data = JSON.parse(this.responseText);

            if (request.status >= 200 && request.status < 400 && !data.erro) {
                document.getElementById("resultado").innerHTML = `
                    <p><strong>Logradouro:</strong> ${data.logradouro}</p>
                    <p><strong>Bairro:</strong> ${data.bairro}</p>
                    <p><strong>Cidade:</strong> ${data.localidade}</p>
                    <p><strong>Estado:</strong> ${data.uf}</p>
                `;
            } else {
                document.getElementById("resultado").innerHTML = "<p>CEP inválido ou não encontrado.</p>";
            }
        };

        request.onerror = function() {
            document.getElementById("resultado").innerHTML = "<p>Erro ao conectar com o servidor.</p>";
        };

        request.send();
    }

    // Função para cancelar a busca e exibir uma mensagem
    function cancelarBusca() {
        document.getElementById("cep").value = ''; // Limpa o campo de CEP
        document.getElementById("resultado").innerHTML =
        "<p>Busca operação cancelada pelo usuário.</p>"; // Exibe mensagem
    }
    </script>
</head>

<body>
    <h1>Buscar Endereço por CEP</h1>

    <!-- Formulário com evento onsubmit para chamar a função buscarCEP sem recarregar a página -->
    <form onsubmit="event.preventDefault(); buscarCEP();">
        <label for="cep">Digite o CEP:</label>
        <input type="text" id="cep" name="cep" value="<?= htmlspecialchars($cep) ?>" required>

        <!-- Botão de envio -->
        <button type="submit">Buscar</button>

        <!-- Botão de cancelar que chama a função cancelarBusca -->
        <button type="button" onclick="cancelarBusca()">Cancelar</button>
    </form>

    <!-- Área onde os dados do endereço serão exibidos -->
    <div id="resultado" style="margin-top: 20px;"></div>
</body>

</html>