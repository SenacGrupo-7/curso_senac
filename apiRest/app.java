package apiRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class app {

    public static void main(String[] args) {
             String url = "jdbc:mysql://localhost:3306/bdApi";
        String usuario = "root";
        String senha = "";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ Conexão com o banco de dados estabelecida com sucesso!");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
}
