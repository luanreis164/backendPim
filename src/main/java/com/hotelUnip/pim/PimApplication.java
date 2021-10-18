package com.hotelUnip.pim;

import com.hotelUnip.pim.domain.*;
import com.hotelUnip.pim.domain.enums.EstadoPagamento;;
import com.hotelUnip.pim.repositories.*;
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


	public static void main(String[] args) {
		SpringApplication.run(PimApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
