package main.jpa;

import main.dao.jpa.ClienteJpaDAO;
import main.dao.jpa.IClienteJpaDAO;
import main.domain.jpa.ClienteJpa;
import main.exceptions.DAOException;
import main.exceptions.MaisDeUmRegistroException;
import main.exceptions.TableException;
import main.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ClienteJpaDaoTest {
    private IClienteJpaDAO clienteDao;
    private Random rd;

    public ClienteJpaDaoTest(){
        this.clienteDao = new ClienteJpaDAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException{
        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        list.forEach(clienteJpa -> {try {
            clienteDao.excluir(clienteJpa);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException,DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        clienteDao.cadastrar(clienteJpa);

        ClienteJpa clienteConsultado = clienteDao.consultar(clienteJpa.getId());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(clienteJpa);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteDao.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(clienteJpa);

        ClienteJpa clienteConsultado1 = clienteDao.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado1);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(clienteJpa);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteDao.consultar(clienteJpa.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Aylã");
        clienteDao.alterar(clienteConsultado);

        ClienteJpa clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Aylã", clienteAlterado.getNome());

        clienteDao.excluir(clienteJpa);
        clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(clienteJpa);
        Assert.assertNotNull(retorno);

        ClienteJpa cliente1 = criarCliente();
        ClienteJpa retorno1 = clienteDao.cadastrar(cliente1);
        Assert.assertNotNull(retorno1);

        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(clienteJpa1 -> {
            try {
                clienteDao.excluir(clienteJpa1);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }

    private ClienteJpa criarCliente(){
        ClienteJpa clienteJpa = new ClienteJpa();
        clienteJpa.setCpf(rd.nextLong());
        clienteJpa.setNome("Axwel");
        clienteJpa.setCidade("Teresina");
        clienteJpa.setEnd("Noé FOrtes");
        clienteJpa.setEstado("Piauí");
        clienteJpa.setNumero(400);
        clienteJpa.setTel(40028922L);
        clienteJpa.setSexo("Masculino");
        return clienteJpa;
    }
}
