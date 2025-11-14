package main.dao.generic.jpa;

import main.dao.Persistente;

import java.io.Serializable;


public abstract class GenericJpaDB1DAO<T extends Persistente, E extends Serializable> extends GenericJpaDAO<T,E>{
    public GenericJpaDB1DAO(Class<T> persistenteClass){
        super(persistenteClass,"Modulo36P1");
    }

}

