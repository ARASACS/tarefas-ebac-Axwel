import main.dao.IProdutoDao;
import main.dao.ProdutoDao;
import main.domain.Produto;
import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProdutoTest {

    IProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }

    @After
    public void end() {
        List<Produto> list = produtoDao.buscarTodos();
        list.forEach(cli -> produtoDao.excluir(cli));
    }

    @Test
    public void cadastrar() {
        Produto produto = criarProduto();
        assertNotNull(produto);

        Produto produtoDB = produtoDao.buscarPorID(produto.getId());
        assertNotNull(produtoDB);
        assertEquals(produto.getId(), produtoDB.getId());
        assertEquals(produto.getNome(), produtoDB.getNome());

    }

    @Test
    public void alterar() {
        Produto cliente = criarProduto();
        assertNotNull(cliente);

        Produto produtoDB = produtoDao.buscarPorID(cliente.getId());
        assertNotNull(produtoDB);
        assertEquals(cliente.getId(), produtoDB.getId());
        assertEquals(cliente.getNome(), produtoDB.getNome());

        produtoDB.setNome("Rodrigo Pires");
        Produto produtoUp = produtoDao.alterar(produtoDB);
        assertEquals("Rodrigo Pires", produtoUp.getNome());
        
    }

    private Produto criarProduto() {
        Produto produto = new Produto();
        produto.setNome("Computador");
        produto.setDescricao("Ryzen");
        produto.setPreco(BigDecimal.valueOf(2334.3));
        produto.setQuantidade(2);
        produto.setCategoria("Tecnologia");
        produto.setCodigo("4B5621");
        produto.setDataCadastro(Instant.now());
        produto = produtoDao.cadastrar(produto);
        return produto;
    }
}