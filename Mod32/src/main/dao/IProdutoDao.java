package main.dao;

import main.domain.Produto;

import java.util.List;

public interface IProdutoDao {
    public Produto cadastrar(Produto produto);

    public Produto buscarPorID(Long id);

    public void excluir(Produto produto);

    public Produto alterar(Produto produto);

    public List<Produto> buscarTodos();
}
