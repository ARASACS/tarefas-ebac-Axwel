package main.dao.jpa;

import main.dao.generic.jpa.GenericJpaDAO;
import main.dao.generic.jpa.GenericJpaDB1DAO;
import main.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

    public ClienteJpaDAO(){
        super(ClienteJpa.class);
    }


}
