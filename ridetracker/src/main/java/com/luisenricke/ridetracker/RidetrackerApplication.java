package com.luisenricke.ridetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RidetrackerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(RidetrackerApplication.class, args);
		System.out.println("\n\n ------- Start app ------- \n\n");
	}

}
