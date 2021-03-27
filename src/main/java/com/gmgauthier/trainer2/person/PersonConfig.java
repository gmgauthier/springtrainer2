package com.gmgauthier.trainer2.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner CLRunner(PersonRepository repository) {
        return args -> {
            Person greg = new Person(
                    "Greg",
                    LocalDate.of(1967, Month.AUGUST, 9),
                    "gmgauthier@protonmail.com"
            );
            Person tom = new Person(
                    "Tom",
                    LocalDate.of(1968, Month.DECEMBER, 19),
                    "tom@whereverheis.com"
            );
            Person steven = new Person(
                    "Steven",
                    LocalDate.of(1972, Month.JUNE, 9),
                    "steve@whereverheis.com"
            );
            Person chris = new Person(
                    "Chris",
                    LocalDate.of(1974, Month.JANUARY, 10),
                    "steve@whereverheis.com"
            );
            Person john = new Person(
                    "John",
                    LocalDate.of(1980, Month.AUGUST, 17),
                    "steve@whereverheis.com"
            );

            repository.saveAll(
                    List.of(greg, tom, steven, chris, john)
            );

        };
    }
}
