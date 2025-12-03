package controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.Carro;
import service.ICarroService;


@Named
@ViewScoped
public class CarroController  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7533802394781783570L;
	
private Carro carro;
	
	private Collection<Carro> carros;
	
	@Inject
	private ICarroService carroService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.carro = new Carro();
			this.carros = carroService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os clientes"));
		}
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Collection<Carro> getCarros() {
		return carros;
	}

	public void setCarros(Collection<Carro> carros) {
		this.carros = carros;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}	
	
	

}
