package dao.generic;

import domain.Placa;

public interface IGenericDAO <T extends Placa> {
    public boolean cadastrar (T entity);
}
