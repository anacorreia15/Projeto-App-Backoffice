package com.projeto.Backendmicroservice;

import com.projeto.Backendmicroservice.Ementa.Ementa;
import com.projeto.Backendmicroservice.Ementa.RepositorioEmentas;
import com.projeto.Backendmicroservice.Refeicao.RepositorioRefeicoes;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@AllArgsConstructor
@SpringBootApplication
public class BackendMicroserviceApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendMicroserviceApplication.class, args);
	}

	final RepositorioRefeicoes repositorioRefeicoes;
	final RepositorioEmentas repositorioEmentas;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Refeicao refeicao = new Refeicao(LocalDate.now(),5);
		//repositorioRefeicoes.save(refeicao);

		//Ementa ementa = new Ementa(LocalDate.now(), "canja", 50);
		//repositorioEmentas.save(ementa);
	}
}