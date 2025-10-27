import dao.AcessorioDao;
import dao.CarroDao;
import dao.IAcessorioDao;
import dao.ICarroDao;
import dao.IMarcaDao;
import dao.MarcaDao;
import domain.Acessorio;
import domain.Carro;
import domain.Marca;
import org.junit.Test;

public class CarroTest {
    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;

    public CarroTest(){
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }
    @Test
    public void cadastrar(){
        Marca marca = cadastrarMarca();
        Acessorio acessorio = cadastrarAcessorio();

        Carro carro = new Carro();
        carro.setAno("2004");
        carro.setModelo("CIVIC");
        carro.setMarca(marca);
        carro.add(acessorio);
        carroDao.cadastrar(carro);
    }


    public Marca cadastrarMarca(){
        Marca marca = new Marca();
        marca.setNome("Honda");
        return marcaDao.cadastrar(marca);
    }

    public Acessorio cadastrarAcessorio(){
        Acessorio acessorio= new Acessorio();
        acessorio.setNome("Som");
        return acessorioDao.cadastrar(acessorio);
    }
    public Carro cadastrarCarro(){
        Carro carro = new Carro();
        carro.setAno("2004");
        carro.setModelo("CIVIC");
        return  carroDao.cadastrar(carro);
    }


}
