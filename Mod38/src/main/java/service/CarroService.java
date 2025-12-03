package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ICarroDao;
import domain.Carro;
import exceptions.DAOException;
import exceptions.MaisDeUmRegistroException;
import exceptions.TableException;
import service.generic.GenericJpaService;

@Stateless
public class CarroService extends GenericJpaService<Carro, Long> implements ICarroService {
	
	@Inject
	public CarroService(ICarroDao clienteDAO) {
		super(clienteDAO);
	}

	
	@Override
	public Carro buscarPorSerial(Long serial) throws DAOException {
		try {
			return this.dao.consultar(serial);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
