package com.luisenricke.trackzilla;

import com.luisenricke.trackzilla.entity.Application;
import com.luisenricke.trackzilla.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrackzillaApplication {

    private static final Logger log = LoggerFactory.getLogger(TrackzillaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrackzillaApplication.class, args);
        System.out.println("\n\n ------- Start app ------- \n\n");
    }
}
