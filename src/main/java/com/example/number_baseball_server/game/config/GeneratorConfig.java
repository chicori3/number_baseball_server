package com.example.number_baseball_server.game.config;


import com.example.number_baseball_server.game.domain.factory.NumbersGenerator;
import com.example.number_baseball_server.game.infrastructure.RandomNumbersGenerate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfig {

    @Bean
    public NumbersGenerator numbersGenerator() {
        return new RandomNumbersGenerate();
    }
}
