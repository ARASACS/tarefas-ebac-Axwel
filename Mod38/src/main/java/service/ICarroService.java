package service;

import domain.Carro;
import exceptions.DAOException;
import service.generic.IGenericJpaService;

public interface ICarroService extends IGenericJpaService<Carro, Long> {

	Carro buscarPorSerial(Long serial) throws DAOException;

}
