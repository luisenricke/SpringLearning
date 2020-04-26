package com.luisenricke.ridetracker.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.luisenricke")
public class JdbcConfiguration {

    @Bean
    public DataSource dataSource() {
        System.out.println("MySQL config");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ride_tracker" +
                          "?useUnicode=true" +
                          "&useJDBCCompliantTimezoneShift=true" +
                          "&useLegacyDatetimeCode=false" +
                          "&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        System.out.println("JdbcTemplate config");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        // jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
}
