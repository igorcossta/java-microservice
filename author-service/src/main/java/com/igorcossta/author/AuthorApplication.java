package com.igorcossta.author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AuthorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
        Author author = Author.builder()
                .name("John")
                .lastName("Doe")
                .age(24)
                .createdAt(LocalDateTime.now())
                .build();
        Author author2 = Author.builder()
                .name("Rebeca")
                .lastName("Doe")
                .age(20)
                .createdAt(LocalDateTime.now().plusHours(74))
                .build();
        authorRepository.saveAll(Arrays.asList(author, author2));
        return args -> {
        };
    }
}
