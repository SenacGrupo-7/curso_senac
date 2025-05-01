package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco";
    private static final String USER = "root";
    private static final String PASSWORD = "sua_senha";

    public void salvarProduto(Produto produto) throws SQLException {
        String query = "INSERT INTO produto (nome, descricao, preco, estoque, categoria, fabricante) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getEstoque());
            stmt.setString(5, produto.getCategoria());
            stmt.setString(6, produto.getFabricante());
            
            stmt.executeUpdate();
        }
    }

    public Produto obterProdutoPorId(long id) throws SQLException {
        String query = "SELECT * FROM produto WHERE id = ?";
        Produto produto = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setFabricante(rs.getString("fabricante"));
            }
        }
        
        return produto;
    }
}
