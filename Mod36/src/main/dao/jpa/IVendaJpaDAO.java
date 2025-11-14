package main.dao.jpa;

import main.dao.generic.jpa.IGenericJpaDAO;
import main.domain.jpa.VendaJpa;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJpa,Long> {
    public void finalizarVenda(VendaJpa venda)throws TipoChaveNaoEncontradaException, DAOException;
    public void cancelarVanda(VendaJpa venda )throws TipoChaveNaoEncontradaException, DAOException;

    public VendaJpa consultarComCollection(Long id);
}
