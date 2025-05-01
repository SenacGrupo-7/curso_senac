package controller;

import model.Produto;
import repository.ProdutoRepository;
import com.google.gson.Gson;  // Importando o Gson necessário para a conversão

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/api/produtos") // Mapeamento da URL para este servlet
public class ProdutoServlet extends HttpServlet {

    private ProdutoRepository produtoRepository;
    private Gson gson;

    // Método init() é chamado uma vez quando o servlet é carregado
    @Override
    public void init() throws ServletException {
        // Inicializa o repositório e o Gson para conversão de JSON
        produtoRepository = new ProdutoRepository(); // A inicialização do repositório
        gson = new Gson();  // Criação do objeto Gson para conversão de JSON
    }

    // Método POST para criar um produto
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lê o JSON enviado no corpo da requisição
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);  // Acumula o JSON recebido
        }

        // Converte o JSON recebido em um objeto Produto
        Produto produto = gson.fromJson(json.toString(), Produto.class);

        // Valida os dados do produto
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Nome do produto é obrigatório");
            return;
        }

        if (produto.getPreco() <= 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Preço do produto deve ser maior que zero");
            return;
        }

        if (produto.getEstoque() < 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Estoque do produto não pode ser negativo");
            return;
        }

        // Salva o produto
        produtoRepository.save(produto);  // Chama o método save do repositório
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Produto criado com sucesso");
    }

    // Método GET para obter um produto por ID
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        
        // Valida se o parâmetro ID foi informado
        if (idParam == null || idParam.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("ID do produto é obrigatório");
            return;
        }

        try {
            long id = Long.parseLong(idParam);  // Converte o parâmetro ID para long
            Produto produto = produtoRepository.findById(id).orElse(null);  // Busca o produto no repositório

            if (produto != null) {
                // Retorna o produto como JSON
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(produto));  // Converte o produto para JSON
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Produto não encontrado");
            }
        } catch (NumberFormatException e) {
            // Trata exceção caso o ID seja inválido
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("ID inválido");
        }
    }
}
