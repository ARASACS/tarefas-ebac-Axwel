package dao.generic;

import domain.Placa;

import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO <T extends Placa>implements IGenericDAO<T> {
    protected Map<Class, Map<String,T>>map;


    public GenericDAO(){
        if (this.map==null) {
            this.map = new HashMap<>();
        }
    }

    @Override
    public boolean cadastrar(T entity) {
        Map<String, T> mapaInterno = this.map.get(getClass());
        if(mapaInterno.containsKey(entity.getPlaca())){
            return false;
        }
        mapaInterno.put(entity.getPlaca(), entity);
        return true;
    }
}
