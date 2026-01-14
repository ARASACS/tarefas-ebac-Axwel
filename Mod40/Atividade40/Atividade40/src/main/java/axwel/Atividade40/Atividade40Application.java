package axwel.Atividade40;

import axwel.domain.Cliente;
import axwel.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "axwel.repository")
@EntityScan("axwel")
@ComponentScan(basePackages = "axwel")
public class Atividade40Application {

	private static final Logger log = LoggerFactory.getLogger(Atividade40Application.class);

	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Atividade40Application.class);
	}


	public void run(String... args) throws Exception {
		log.info("StartApplicattion..., ");
		Cliente cliente = createCliente();
		repository.save(cliente);
		// TODO Auto-generated method stub

	}

	private Cliente createCliente() {
		return Cliente.builder()
				.nome("Axwel")
				.cidade("piripiri")
				.cpf(12312312L)
				.email("Axwelchave@gmail.com")
				.end("Chave")
				.estado("PI")
				.numero(23)
				.sexo("M")
				.tel(323232L)
				.build();


	}
}