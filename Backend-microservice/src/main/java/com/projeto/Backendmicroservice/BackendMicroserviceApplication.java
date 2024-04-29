package com.projeto.Backendmicroservice;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@AllArgsConstructor
@SpringBootApplication
public class BackendMicroserviceApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendMicroserviceApplication.class, args);
	}

	final RepositorioRefeicoes repositorioRefeicoes;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Refeicao refeicao = new Refeicao(LocalDate.now(),5);
		//repositorioRefeicoes.save(refeicao);
	}
}