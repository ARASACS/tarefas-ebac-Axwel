package domainTest;

import domin.Cliente;
import domin.Produto;
import jdbc.dao.ClienteDao;
import jdbc.dao.IClienteDao;
import jdbc.dao.IProdutoDao;
import jdbc.dao.ProdutoDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {
    private IProdutoDao produtoDao;

    @Test
    public void cadastrarTest() throws Exception{
        produtoDao = new ProdutoDao();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Biscoito");
        produto.setPreco(2L);
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produto1 = produtoDao.buscar("10");
        assertNotNull(produto1);
        assertEquals(produto.getCodigo(),produto1.getCodigo());
        assertEquals(produto.getNome(),produto1.getNome());

        Integer countDel = produtoDao.excluir(produto1);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception{
        produtoDao = new ProdutoDao();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Biscoito");
        produto.setPreco(2L);
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produto1 = produtoDao.buscar("10");
        assertNotNull(produto1);
        assertEquals(produto.getCodigo(),produto1.getCodigo());
        assertEquals(produto.getNome(),produto1.getNome());

        Integer countDel = produtoDao.excluir(produto1);
        assertTrue(countDel == 1);
    }
    @Test
    public void excluirTest() throws Exception{
        produtoDao = new ProdutoDao();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Biscoito");
        produto.setPreco(2L);
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produto1 = produtoDao.buscar("10");
        assertNotNull(produto1);
        assertEquals(produto.getCodigo(),produto1.getCodigo());
        assertEquals(produto.getNome(),produto1.getNome());

        Integer countDel = produtoDao.excluir(produto1);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception{
        produtoDao = new ProdutoDao();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Biscoito");
        produto.setPreco(2L);
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoA = new Produto();
        produto.setCodigo("20");
        produto.setNome("Azeitona");
        produto.setPreco(3L);
        Integer countCad1 = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        List<Produto> list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2,list.size());

        for(Produto pro :list){
            produtoDao.excluir(pro);

        }

        list =produtoDao.buscarTodos();
        assertEquals(list.size(),0);

    }

    @Test
    public void atualizarTest() throws Exception{
        produtoDao = new ProdutoDao();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Biscoito");
        produto.setPreco(2L);
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produto1 = produtoDao.buscar("10");
        assertNotNull(produto1);
        assertEquals(produto.getCodigo(),produto1.getCodigo());
        assertEquals(produto.getNome(),produto1.getNome());

        produto1.setCodigo("15");
        produto1.setNome("Bauduco");
        Integer countupdate = produtoDao.atualizar((produto1));
        assertTrue(countupdate == 1);

        Produto produto2 = produtoDao.buscar("10");
        assertNull(produto2);

        Produto produto3 = produtoDao.buscar("15");
        assertNotNull(produto3);
        assertEquals(produto1.getId(),produto3.getId());
        assertEquals(produto1.getNome(),produto3.getNome());
        assertEquals(produto1.getCodigo(),produto3.getCodigo());

        Integer countDel = produtoDao.excluir(produto1);
        assertTrue(countDel == 1);
    }
}

