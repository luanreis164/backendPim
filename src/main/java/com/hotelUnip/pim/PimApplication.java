package com.hotelUnip.pim;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.domain.Pessoa;
import com.hotelUnip.pim.domain.Quarto;
import com.hotelUnip.pim.domain.Reserva;
import com.hotelUnip.pim.repositories.CategoriaRepository;
import com.hotelUnip.pim.repositories.PessoaRepository;
import com.hotelUnip.pim.repositories.QuartoRepository;
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

	@Autowired
	private QuartoRepository quartoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;



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

		Categoria cat1 = new Categoria(null,"Suite Royal 01",205.00);
		Categoria cat2 = new Categoria(null,"Suite Royal Deluxe 01",260.00);

		Quarto quarto1 = new Quarto(null,11,1,cat1);
		Quarto quarto2 = new Quarto(null,12,1,cat2);

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		quartoRepository.saveAll(Arrays.asList(quarto1,quarto2));


	}
}
