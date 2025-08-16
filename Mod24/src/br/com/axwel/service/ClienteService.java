package br.com.axwel.service;

import br.com.axwel.dao.IClienteDao;
import br.com.axwel.dao.IContratoDao;

public class ClienteService implements IClienteDao {
    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;

    }

    public String salvar() {
        clienteDao.salvar();
        return "Sucesso";
    }

    @Override
    public String excluir() {
        clienteDao.excluir();
        return "Excluido";
    }

    @Override
    public String atualizar() {
        clienteDao.atualizar();
        return "Atualizado";
    }

    @Override
    public String buscar() {
        clienteDao.buscar();
        return "Encontrado";
    }
}
