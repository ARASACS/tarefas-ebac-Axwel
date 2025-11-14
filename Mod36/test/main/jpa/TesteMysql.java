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

public class TesteMysql {

    private IClienteJpaDAO<ClienteJpa2> clienteDB3Dao;

    private Random rd;

    public TesteMysql(){
        this.clienteDB3Dao = new ClienteJpaDB3DAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {

        Collection<ClienteJpa2> list3 = clienteDB3Dao.buscarTodos();
        excluir3(list3);
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException,DAOException, MaisDeUmRegistroException, TableException {


        ClienteJpa2 cliente2 = criarCliente2();
        clienteDB3Dao.cadastrar(cliente2);

        ClienteJpa2 clienteConsultado3 = clienteDB3Dao.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado3);

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
