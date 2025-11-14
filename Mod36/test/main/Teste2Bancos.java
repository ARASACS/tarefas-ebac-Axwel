package main;

import main.dao.jpa.ClienteJpaDAO;
import main.dao.jpa.ClienteJpaDB2DAO;
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

public class Teste2Bancos {
    private IClienteJpaDAO<ClienteJpa> clienteDao;

    private IClienteJpaDAO<ClienteJpa> clienteDB2Dao;
    private Random rd;

    public Teste2Bancos(){
        this.clienteDao = new ClienteJpaDAO();
        this.clienteDB2Dao = new ClienteJpaDB2DAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
        excluir1(list1);

        Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
        excluir2(list2);
    }

    private void excluir1(Collection<ClienteJpa> list) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private void excluir2(Collection<ClienteJpa> list) {
        list.forEach(cli -> {
            try {
                clienteDB2Dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa cliente = criarCliente();
        clienteDao.cadastrar(cliente);

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setId(null);
        clienteDB2Dao.cadastrar(cliente);

        ClienteJpa clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteDao.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);

        ClienteJpa clienteConsultado1 = clienteDao.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado1);
    }

    private ClienteJpa criarCliente(){
        ClienteJpa clienteJpa = new ClienteJpa();
        clienteJpa.setCpf(rd.nextLong());
        clienteJpa.setNome("Axwel");
        clienteJpa.setCidade("Teresina");
        clienteJpa.setEnd("Noé Fortes");
        clienteJpa.setEstado("Piauí");
        clienteJpa.setNumero(400);
        clienteJpa.setTel(40028922L);
        clienteJpa.setSexo("Masculino");
        return clienteJpa;
    }
}
