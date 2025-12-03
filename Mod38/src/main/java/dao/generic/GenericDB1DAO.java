package dao.generic;

import java.io.Serializable;

import dao.Persistente;
import dao.generic.GenericJpaDAO;
import domain.Carro;

public abstract class GenericDB1DAO<T extends Persistente, E extends Serializable> extends GenericJpaDAO<T,E>{
    public GenericDB1DAO(Class<T> persistenteClass) {
    	super(persistenteClass,"AtividadeM38");
	}

	

	

}
