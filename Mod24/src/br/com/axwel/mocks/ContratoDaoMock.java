package br.com.axwel.mocks;
import br.com.axwel.dao.IContratoDao;

public class ContratoDaoMock implements IContratoDao {

    @Override
    public String salvar(){
        throw new UnsupportedOperationException("Não funciona sem config de banco");
    }

    @Override
    public String excluir() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");
    }

    @Override
    public String buscar() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");
    }
}
