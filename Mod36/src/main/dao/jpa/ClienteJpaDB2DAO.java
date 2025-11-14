package main.dao.jpa;

import main.dao.generic.jpa.GenericJpaDB2DAO;
import main.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDB2DAO(){
        super(ClienteJpa.class);
    }


}
