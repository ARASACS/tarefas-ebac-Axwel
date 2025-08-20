package service;

import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;
import exceptions.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO){
        this.clienteDAO =  clienteDAO;
    }
    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {

        return clienteDAO.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);

    }
}
