import br.com.axwel.dao.ContratoDao;
import br.com.axwel.dao.IContratoDao;
import br.com.axwel.mocks.ContratoDaoMock;
import br.com.axwel.service.ContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao salvar = new ContratoDao();
        ContratoService service = new ContratoService(salvar);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        service.salvar(); // Deve lançar exceção
    }

    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDao();
        ContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Encontrado", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        service.buscar();
    }

    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDao();
        ContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluido", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        service.excluir();
    }

    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDao();
        ContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Atualizado", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAtualizarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        service.atualizar();
    }
}
