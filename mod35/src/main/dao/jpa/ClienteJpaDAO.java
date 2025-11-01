package main.dao.jpa;

import main.dao.generic.jpa.GenericJpaDAO;
import main.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO(){
        super(ClienteJpa.class);
    }


}
