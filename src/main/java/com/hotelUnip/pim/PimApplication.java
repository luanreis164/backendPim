package com.hotelUnip.pim;

import com.hotelUnip.pim.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class PimApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(PimApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
