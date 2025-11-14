package main.dao.jpa;

import main.dao.generic.jpa.GenericJpaDB2DAO;
import main.dao.generic.jpa.GenericJpaDB3DAO;
import main.dao.generic.jpa.IGenericJpaDAO;
import main.domain.jpa.ClienteJpa;
import main.domain.jpa.ClienteJpa2;

public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

    public ClienteJpaDB3DAO(){
        super(ClienteJpa2.class);
    }


}
