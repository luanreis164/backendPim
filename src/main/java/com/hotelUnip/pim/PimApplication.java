package com.hotelUnip.pim;

import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.repositories.PessoaRepository;
import com.hotelUnip.pim.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class PimApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PimApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Pessoa p1 = new Pessoa(null, "Luan", "48000547880", "Rua Josefina Bakhita","Vila Sonia", "527", "11722330",
				"Praia Grande", "São Paulo", "13996735588", "556481550",sdf.parse("22/02/1999"));

		Pessoa p2 = new Pessoa(null, "Jao", "13354879977", "Rua Josefina Bakhita","Vila Sonia", "527", "11722330",
				"Praia Grande", "São Paulo", "13996735588", "556481550",sdf.parse("22/02/1999"));

		Reserva reserva1 = new Reserva(null,sdf.parse("25/11/2021"),sdf.parse("22/12/2021"),35,p1);
		Reserva reserva2 = new Reserva(null,sdf.parse("25/11/2021"),sdf.parse("22/12/2021"),35,p1);

		p1.setReserva(reserva1);
		p2.setReserva(reserva2);
		reserva1.setPessoa(p1);
		reserva2.setPessoa(p2);

		pessoaRepository.saveAll(Arrays.asList(p1,p2));
		reservaRepository.saveAll(Arrays.asList(reserva1,reserva2));

	}
}
