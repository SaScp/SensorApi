package ru.alex.restapipractic;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestapipracticApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapipracticApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();
    }
}
