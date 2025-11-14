package main.dao.jpa;

import main.dao.Persistente;
import main.dao.generic.jpa.IGenericJpaDAO;
import main.domain.jpa.ClienteJpa;

public interface IClienteJpaDAO<T extends Persistente>  extends IGenericJpaDAO<T, Long> {
}
