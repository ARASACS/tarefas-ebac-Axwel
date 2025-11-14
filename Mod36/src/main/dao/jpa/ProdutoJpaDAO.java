package main.dao.jpa;

import main.dao.generic.jpa.GenericJpaDAO;
import main.dao.generic.jpa.GenericJpaDB1DAO;
import main.dao.generic.jpa.GenericJpaDB2DAO;
import main.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO{
    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }
}
