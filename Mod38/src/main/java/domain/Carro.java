package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "MODELO", length = 50, nullable = false)
    private  String modelo;
    
    @Column(name = "Serial", length = 100, nullable = false, unique = true)
    private Long serial;


    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "acessorio", length = 50, nullable = false)
    private String acessorio;

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    

	public Long getSerial() {
		return serial;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}

	public String getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(String acessorio) {
		this.acessorio = acessorio;
	}
	
    
    
}
