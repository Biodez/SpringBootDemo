package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(

                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER, 12)
            );
            Student afeez = new Student(
                    "Afeez",
                    "oladokunabiodun92@gmail.com",
                    LocalDate.of(1992, Month.DECEMBER, 18)
            );

            repository.saveAll(
                    List.of(mariam, afeez)
            );

        };
    }
}
