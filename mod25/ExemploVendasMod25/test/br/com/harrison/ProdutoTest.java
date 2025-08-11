package br.com.harrison;

import br.com.harrison.Dao.ProdutoDao;
import br.com.harrison.produto.Produto;
import br.com.harrison.service.IProdutoService;
import br.com.harrison.service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    public void produtoTest(){

        int random = (int) (Math.random() * 1000);

        IProdutoService produtoService = new ProdutoService(new ProdutoDao());

        Produto produto = new Produto(random, "Notebook", 1234567890L, 1000.0, 10);
        produtoService.salvarProduto(random, produto);
       Assertions.assertEquals(produto, produtoService.consultarProdutoCodigoInterno(produto.getCodigoInterno()));
    }


}
