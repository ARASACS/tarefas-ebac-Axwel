package dao;


import dao.generic.GenericDAO;
import dao.generic.IGenericDAO;
import domain.Toyota;

import java.util.HashMap;
import java.util.Map;

public class ToyotaDAO  extends GenericDAO<Toyota> implements IToyotaDAO {
    public ToyotaDAO(){
        super();
        Map<String, Toyota> mapaInterno = this.map.get(getClass());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            this.map.put(getClass(), mapaInterno);
        }
    }

}
