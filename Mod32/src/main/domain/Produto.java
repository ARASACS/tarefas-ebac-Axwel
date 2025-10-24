package main.domain;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="produto_seq")
    @SequenceGenerator(name="produto_seq", sequenceName="sq_produto", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME",nullable = false, length = 100)
    private String nome;

    @Column(name = "DESCRICAO",length = 500)
    private String descricao;

    @Column(name = "PRECO",nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "QUANTIDADE",nullable = false)
    private Integer quantidade;

    @Column(name = "CATEGORIA",length = 100)
    private String categoria;

    @Column(name = "CODIGO",length = 50, unique = true)
    private String codigo;

    @Column(name = "DATA_CADASTRO",nullable = false)
    private Instant dataCadastro ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
