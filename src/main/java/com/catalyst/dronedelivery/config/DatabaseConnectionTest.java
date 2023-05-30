package com.catalyst.dronedelivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionTest implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String result = jdbcTemplate.queryForObject("SELECT 1", String.class);
        System.out.println("Database connection test successful. Result: " + result);
    }
}

