package com.luisenricke.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// This is a example of how to setting configurations
@Configuration
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource() {
        System.out.println("My custom data source bean has been init and set");
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/conference_demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .build();
    }
}
