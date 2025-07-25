package dao;

import dao.generic.GenericDAO;
import domain.Ford;
import domain.Toyota;

import java.util.HashMap;
import java.util.Map;

public class FordDAO extends GenericDAO<Ford> implements IFordDAO {
    public FordDAO(){
        super();
        Map<String, Ford> mapaInterno = this.map.get(getClass());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            this.map.put(getClass(), mapaInterno);
        }
    }

}
