import dao.ClienteDAO;
import dao.ClienteDaoMock;
import dao.IClienteDAO;
import domain.Cliente;
import exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDAO = new ClienteDaoMock();
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

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
    public void excluirCliente(){
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Axwel Rafael");
        clienteDAO.alterar(cliente);
        Assert.assertEquals("Axwel Rafael",cliente.getNome());
    }
}
