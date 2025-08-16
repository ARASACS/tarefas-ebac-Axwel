import br.com.axwel.dao.ClienteDao;
import br.com.axwel.dao.ContratoDao;
import br.com.axwel.dao.IClienteDao;
import br.com.axwel.dao.IContratoDao;
import br.com.axwel.mocks.ClienteDaoMock;
import br.com.axwel.mocks.ContratoDaoMock;
import br.com.axwel.service.ClienteService;
import br.com.axwel.service.ContratoService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        IClienteDao salvar = new ClienteDao();
        ClienteService service = new ClienteService(salvar);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IClienteDao dao = new ClienteDaoMock();
        ClienteService service = new ClienteService(dao);
        service.salvar();
    }

    @Test
    public void buscarTest() {
        IClienteDao dao = new ClienteDao();
        ClienteService service = new ClienteService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Encontrado", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarComBancoDeDadosTest() {
        IClienteDao dao = new ClienteDaoMock();
        ClienteService service = new ClienteService(dao);
        service.buscar();
    }

    @Test
    public void excluirTest() {
        IClienteDao dao = new ClienteDao();
        ClienteService service = new ClienteService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluido", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirComBancoDeDadosTest() {
        IClienteDao dao = new ClienteDaoMock();
        ClienteService service = new ClienteService(dao);
        service.excluir();
    }

    @Test
    public void atualizarTest() {
        IClienteDao dao = new ClienteDao();
        ClienteService service = new ClienteService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Atualizado", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAtualizarComBancoDeDadosTest() {
        IClienteDao dao = new ClienteDaoMock();
        ClienteService service = new ClienteService(dao);
        service.atualizar();
    }
}