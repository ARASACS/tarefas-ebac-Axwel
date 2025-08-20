package dao;

import dao.generics.GenericDAO;
import domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteDAO(){
        super();
    }

    @Override
    public Class<Cliente> getTipoClass() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
