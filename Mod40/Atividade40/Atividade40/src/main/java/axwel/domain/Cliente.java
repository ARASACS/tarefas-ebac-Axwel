package axwel.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "CPF", length = 100, nullable = false, unique = true)
    private Long cpf;

    @Column(name = "TELEFONE", nullable = false)
    private Long tel;

    @Column(name = "ENDERECO", length = 100, nullable = false)
    private String end;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "CIDADE", length = 100, nullable = false)
    private String cidade;

    @Column(name = "ESTADO", length = 50, nullable = false)
    private String estado;

    @Column(name = "SEXO", length = 50,nullable = false)
    private String sexo;
    
    @Column(name = "EMAIL", length = 50,nullable = false)
    private String email;

    
    
    
}
