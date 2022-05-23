package com.igorcossta.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        Book book = Book.builder()
                .authorId(1)
                .name("Livro Muito Doido")
                .description("Um Livro Show De Bola")
                .country("BR")
                .publishedAt(LocalDateTime.now())
                .build();
        bookRepository.save(book);
        return args -> {
        };
    }
}
