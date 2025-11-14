package main;

import main.dao.jpa.ClienteJpaDAO;
import main.dao.jpa.ClienteJpaDB2DAO;
import main.dao.jpa.ClienteJpaDB3DAO;
import main.dao.jpa.IClienteJpaDAO;
import main.domain.jpa.ClienteJpa;
import main.domain.jpa.ClienteJpa2;
import main.exceptions.DAOException;
import main.exceptions.MaisDeUmRegistroException;
import main.exceptions.TableException;
import main.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

public class Teste3Bancos {
    private IClienteJpaDAO<ClienteJpa> clienteDao;

    private IClienteJpaDAO<ClienteJpa> clienteDB2Dao;

    private IClienteJpaDAO<ClienteJpa2> clienteDB3Dao;

    private Random rd;

    public Teste3Bancos(){
        this.clienteDao = new ClienteJpaDAO();
        this.clienteDB2Dao = new ClienteJpaDB2DAO();
        this.clienteDB3Dao = new ClienteJpaDB3DAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        excluir(list, clienteDao);

        Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
        excluir(list2, clienteDB2Dao);

        Collection<ClienteJpa2> list3 = clienteDB3Dao.buscarTodos();
        excluir3(list3);
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException,DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa cliente = criarCliente();
        clienteDao.cadastrar(cliente);

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setId(null);
        clienteDB2Dao.cadastrar(cliente);

        ClienteJpa clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

        ClienteJpa2 cliente2 = criarCliente2();
        clienteDB3Dao.cadastrar(cliente2);

        ClienteJpa2 clienteConsultado3 = clienteDB3Dao.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado3);

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

    private void excluir(Collection<ClienteJpa> list, IClienteJpaDAO<ClienteJpa> clienteDao) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private void excluir3(Collection<ClienteJpa2> list) {
        list.forEach(cli -> {
            try {
                clienteDB3Dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private ClienteJpa2 criarCliente2() {
        ClienteJpa2 cliente = new ClienteJpa2();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }
}
