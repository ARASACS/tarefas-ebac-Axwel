
import dao.IMarcaDao;
import dao.MarcaDao;
import domain.Marca;
import org.junit.Test;

public class MarcaTest {
    private IMarcaDao marcaDao;
    public MarcaTest(){
        marcaDao = new MarcaDao();
    }
    @Test
    public void cadastrar(){
        Marca marca = new Marca();
        marca.setNome("Honda");
        marcaDao.cadastrar(marca);
    }
}
