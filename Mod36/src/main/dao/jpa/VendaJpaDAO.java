package main.dao.jpa;

import main.dao.generic.jpa.GenericJpaDAO;
import main.dao.generic.jpa.GenericJpaDB1DAO;
import main.domain.jpa.ClienteJpa;
import main.domain.jpa.ProdutoJpa;
import main.domain.jpa.VendaJpa;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class VendaJpaDAO extends GenericJpaDB1DAO<VendaJpa,Long> implements IVendaJpaDAO {

    public VendaJpaDAO() {
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);

    }

    @Override
    public void cancelarVanda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);

    }

    @Override
    public VendaJpa consultarComCollection(Long id) {
        openConnection();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VendaJpa> query = builder.createQuery(VendaJpa.class);
        Root<VendaJpa> root = query.from(VendaJpa.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<VendaJpa> tpQuery = entityManager.createQuery(query);
        VendaJpa venda = tpQuery.getSingleResult();
        closeConnection();
        return venda;
    }

    @Override
    public VendaJpa cadastrar(VendaJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            openConnection();
            entity.getProdutos().forEach(produtoQuantidadeJpa -> {
                ProdutoJpa produtoJpa = entityManager.merge(produtoQuantidadeJpa.getProduto());
                produtoQuantidadeJpa.setProduto(produtoJpa);
            });
            ClienteJpa cliente = entityManager.merge(entity.getCliente());
            entity.setCliente(cliente);
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            closeConnection();
            return entity;
        } catch (Exception e) {
            throw new DAOException("ERRO SALVANDO VENDA",e);
        }

    }

    @Override
    public void excluir(VendaJpa entity) throws DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    private void openConnection() {
        entityManagerFactory  = Persistence.createEntityManagerFactory("Modulo35");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
    }

    private void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
