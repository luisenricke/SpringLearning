package com.luisenricke.restwithspring.config;

import com.luisenricke.restwithspring.entity.Employee;
import com.luisenricke.restwithspring.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabaseConfiguration {

    @Bean
    public CommandLineRunner init(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository
                    .save(new Employee("Luis Villalobos", "Developer")));
            log.info("Preloading " + repository
                    .save(new Employee("Nashe Osorio", "Project manager")));
        };
    }
}
