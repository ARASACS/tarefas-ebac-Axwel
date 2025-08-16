package br.com.axwel.service;

import br.com.axwel.dao.IContratoDao;

public class ContratoService implements IContratoDao {
    private IContratoDao contratoDao;

    public ContratoService(IContratoDao contratoDao) {
        this.contratoDao = contratoDao;
        ;
    }

    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Excluido";
    }

    @Override
    public String atualizar() {
        contratoDao.atualizar();
        return "Atualizado";
    }

    @Override
    public String buscar() {
        contratoDao.buscar();
        return "Encontrado";
    }

}
