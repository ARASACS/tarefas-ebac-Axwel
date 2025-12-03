
import org.junit.Test;

import dao.CarroDao;
import dao.ICarroDao;
import domain.Carro;
import exceptions.DAOException;
import exceptions.TipoChaveNaoEncontradaException;

public class CarroTest {
    private ICarroDao carroDao;

    public CarroTest(){
        carroDao = new CarroDao();
    }
    @Test
    public void cadastrar()throws TipoChaveNaoEncontradaException,DAOException{

        Carro carro = new Carro();
        carro.setModelo("CIVIC");
        carro.setSerial(1234L);
        carro.setMarca("Toyota");
        carro.setAcessorio("Som");
        carroDao.cadastrar(carro);
    }


    


}
