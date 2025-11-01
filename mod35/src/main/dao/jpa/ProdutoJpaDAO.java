package main.dao.jpa;

import main.dao.generic.jpa.GenericJpaDAO;
import main.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO{
    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }
}
