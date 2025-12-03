package dao;

import domain.Carro;
import exceptions.DAOException;
import exceptions.MaisDeUmRegistroException;
import exceptions.TableException;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.generic.GenericDB1DAO;

public class CarroDao extends GenericDB1DAO<Carro,Long> implements ICarroDao{
	public CarroDao(){
        super(Carro.class);
    }

	


}
