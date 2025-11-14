package main.dao.generic.jpa;

import main.dao.Persistente;

import java.io.Serializable;

public class GenericJpaDB3DAO<T extends Persistente, E extends Serializable> extends GenericJpaDAO<T,E> {
    public GenericJpaDB3DAO(Class<T> persistenteClass){
        super(persistenteClass,"Modulo36MySQL");
    }
}
