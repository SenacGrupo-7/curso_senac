package service;

import java.sql.SQLException;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void salvarProduto(Produto produto) throws SQLException {
        produtoDAO.salvarProduto(produto);
    }

    public Produto obterProdutoPorId(long id) throws SQLException {
        return produtoDAO.obterProdutoPorId(id);
    }
}

