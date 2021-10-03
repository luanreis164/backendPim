package com.hotelUnip.pim;

import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class PimApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PimApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Pessoa p1 = new Pessoa(null, "Luan", "48000547880", "Rua Josefina Bakhita","Vila Sonia", "527", "11722330",
				"Praia Grande", "São Paulo", "13996735588", "556481550",sdf.parse("22/02/1999"));

		pessoaRepository.saveAll(Arrays.asList(p1));

	}
}
