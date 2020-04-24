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
        System.out.println("Start app");
    }

    @Bean
    public CommandLineRunner demoApplicationRepository(ApplicationRepository repository) {
        return (args) -> {
            repository.save(new Application("TrackZilla", "Application for tracking bugs.", "luis.villalobos"));
            repository.save(new Application("Expenses", "Application to track expense reports.", "nashe.osorio"));
            repository.save(new Application("Notifications",
                                            "Application to send alets and notifications to users.",
                                            "test.test"
            ));

            for (Application application : repository.findAll()) {
                log.info("The app is: " + application.toString());
            }
        };
    }

}
