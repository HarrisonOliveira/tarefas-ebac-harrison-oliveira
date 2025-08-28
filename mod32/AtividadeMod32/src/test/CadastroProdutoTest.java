import com.atividademod32.entity.ProdutoEntity;
import com.atividademod32.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CadastroProdutoTest {
    @Test
    public void cadastroProdutoTest() {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        ProdutoRepository produtoRepository = new ProdutoRepository();

        produtoEntity.setCodigoInterno("PROD-01");
        produtoEntity.setNome("Produto 3");
        produtoEntity.setValor(new java.math.BigDecimal("100.00"));

        produtoRepository.cadastroProduto(produtoEntity);

        System.out.println(produtoEntity);
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Test
    public void buscaProdutoPorCodigoTest() {
        ProdutoRepository produtoRepository = new ProdutoRepository();
        ProdutoEntity produto = produtoRepository.buscaProdutoPorCodigo("PROD-01");

        Assertions.assertNotNull(produto);
        System.out.println(produto);
    }

    @Test
    public void buscarTodosProdutosTest() {
        ProdutoRepository produtoRepository = new ProdutoRepository();
        List<ProdutoEntity> produtos = produtoRepository.buscarTodosProdutos();

        Assertions.assertNotNull(produtos);

        produtos.forEach(System.out::println);
    }

    @Test
    public void atiluzarNomeDoProdutoTest() {
        ProdutoRepository produtoRepository = new ProdutoRepository();

        Assertions.assertNotNull(produtoRepository.buscaProdutoPorCodigo("PROD-01"));
        produtoRepository.atiluzarNomeDoProduto("Produto 1 - Atualizado", "PROD-01");

        System.out.println(produtoRepository.buscaProdutoPorCodigo("PROD-01"));
    }

    @Test
    public void excluirProdutoTest() {
        ProdutoRepository produtoRepository = new ProdutoRepository();

        Assertions.assertNotNull(produtoRepository.buscaProdutoPorCodigo("PROD-01"));
        produtoRepository.excluirProduto("PROD-01");

    }
}

