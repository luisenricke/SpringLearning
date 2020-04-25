package com.luisenricke.ridetracker.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistanceConfiguration {

    @Bean
    public DataSource mySQL() {
        System.out.println("MySQL init");
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/ride_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .build();
    }

    @Bean
    public DataSource h2() {
        System.out.println("H2 init");
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:ride_tracker")
                .build();
    }
}
