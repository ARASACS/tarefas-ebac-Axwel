import dao.ClienteDaoMock;
import dao.IClienteDAO;
import domain.Cliente;
import exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ClienteService;
import service.IClienteService;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDAO dao =new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(12312312390L);
        cliente.setNome("Axwel");
        cliente.setCidade("Piripiri");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(867004999L);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void pesquisarCliente(){

        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Axwel Rafael");
        clienteService.alterar(cliente);
        Assert.assertEquals("Axwel Rafael",cliente.getNome());
    }


}
