package domainTest;

import domin.Cliente;
import jdbc.dao.ClienteDao;
import jdbc.dao.IClienteDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {
    private IClienteDao clienteDao;

    @Test
    public void cadastrarTest() throws Exception{
        clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Axwel");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDao.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());
        assertEquals(cliente.getNome(),clienteBD.getNome());

        Integer countDel = clienteDao.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception{
        clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Axwel");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDao.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());
        assertEquals(cliente.getNome(),clienteBD.getNome());

        Integer countDel = clienteDao.excluir(clienteBD);
        assertTrue(countDel == 1);
    }
    @Test
    public void excluirTest() throws Exception{
        clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Axwel");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDao.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());
        assertEquals(cliente.getNome(),clienteBD.getNome());

        Integer countDel = clienteDao.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception{
        clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Axwel");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("20");
        cliente1.setNome("Aylã");
        Integer countCad1 = clienteDao.cadastrar(cliente1);
        assertTrue(countCad1 == 1);

        List<Cliente> list = clienteDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2,list.size());

        for(Cliente cli :list){
            clienteDao.excluir(cli);

        }

        list =clienteDao.buscarTodos();
        assertEquals(list.size(),0);

    }

    @Test
    public void atualizarTest() throws Exception{
        clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Axwel");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDao.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());
        assertEquals(cliente.getNome(),clienteBD.getNome());

        clienteBD.setCodigo("20");
        clienteBD.setNome("Aylã");
        Integer countupdate = clienteDao.atualizar((clienteBD));
        assertTrue(countupdate == 1);

        Cliente clienteBD1 = clienteDao.buscar("10");
        assertNull(clienteBD1);

        Cliente clienteBD2 = clienteDao.buscar("20");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(),clienteBD2.getId());
        assertEquals(clienteBD.getNome(),clienteBD2.getNome());
        assertEquals(clienteBD.getCodigo(),clienteBD2.getCodigo());

        Integer countDel = clienteDao.excluir(clienteBD);
        assertTrue(countDel == 1);
    }
}
