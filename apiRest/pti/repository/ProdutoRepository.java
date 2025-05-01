package repository;

import model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();
    private long currentId = 1;

    // Salva um produto (em memória)
    public Produto save(Produto produto) {
        produto.setId(currentId++);
        produtos.add(produto);
        return produto;
    }

    // Encontra um produto por ID
    public Optional<Produto> findById(long id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst();
    }

    // Encontra todos os produtos
    public List<Produto> findAll() {
        return produtos;
    }

    // Deleta um produto por ID
    public boolean delete(long id) {
        return produtos.removeIf(p -> p.getId() == id);
    }
}
