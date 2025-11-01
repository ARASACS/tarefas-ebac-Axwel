package main.domain.jpa;

import main.dao.Persistente;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "TB_VENDA")
public class VendaJpa implements Persistente {

    public enum Status{
        INICIADA,CONCLUIDA,CANCELADA;
        public static Status getByName(String value){
            for (Status status:Status.values()){
                if(status.name().equals(value)){
                    return status;
                }
            }
            return null;
        }
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="venda_seq")
    @SequenceGenerator(name="venda_seq", sequenceName="sq_venda", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false,unique = true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk",foreignKey = @ForeignKey(name = "fk_cliente_venda"),referencedColumnName = "id",nullable = false)
    private ClienteJpa cliente;

    @OneToMany(mappedBy = "venda",cascade = CascadeType.ALL)
    private Set<ProdutoQuantidadeJpa> produtos;


    @Column(name = "VALOR_TOTAL", length = 10, nullable = false,unique = true)
    private BigDecimal valorTotal;

    @Column(name = "DATA_VENDA", length = 10, nullable = false,unique = true)
    private Instant dataVenda;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_VENDA",nullable = false)
    private Status status;

    public VendaJpa() {
        produtos = new HashSet<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ClienteJpa getCliente() {
        return cliente;
    }

    public void setCliente(ClienteJpa cliente) {
        this.cliente = cliente;
    }

    public Set<ProdutoQuantidadeJpa> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(ProdutoJpa produto, Integer quantidade){
        validarStatus();
        Optional<ProdutoQuantidadeJpa> optionalProdutoQuantidadeJpa = produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
        if(optionalProdutoQuantidadeJpa.isPresent()){
            ProdutoQuantidadeJpa produtoQuantidadeJpa = optionalProdutoQuantidadeJpa.get();
            produtoQuantidadeJpa.adicionar(quantidade);
        }else {
            ProdutoQuantidadeJpa prod = new ProdutoQuantidadeJpa();
            prod.setVenda(this);
            prod.setProduto(produto);
            prod.adicionar(quantidade);
            produtos.add(prod);
        }
        recalcularValorTotalVenda();
    }

    private void validarStatus(){
        if(this.status == Status.CONCLUIDA){
            throw new UnsupportedOperationException("IMPOSSIVEL ALTERAR VENDA FINALIZADA");
        }
    }
    public void recalcularValorTotalVenda(){
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(ProdutoQuantidadeJpa prod : this.produtos){
            valorTotal = valorTotal.add(prod.getValorTotal());
        }
        this.valorTotal=valorTotal;
    }
    public void removerProduto(ProdutoJpa produto, Integer quantidade) {
        validarStatus();
        Optional<ProdutoQuantidadeJpa> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();

        if (op.isPresent()) {
            ProdutoQuantidadeJpa produtpQtd = op.get();
            if (produtpQtd.getQuantidade()>quantidade) {
                produtpQtd.remover(quantidade);
                recalcularValorTotalVenda();
            } else {
                produtos.remove(op.get());
                recalcularValorTotalVenda();
            }

        }
    }
    public void removerTodosProdutos() {
        validarStatus();
        produtos.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos() {
        int result = produtos.stream()
                .reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
        return result;
    }

    public void setProdutos(Set<ProdutoQuantidadeJpa> produtos) {

        this.produtos = produtos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
