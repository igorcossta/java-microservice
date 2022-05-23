package com.igorcossta.author;

import com.igorcossta.common.author.AuthorDTO;
import com.igorcossta.common.author.AuthorRequest;
import com.igorcossta.common.exception.AuthorNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.util.Collections.emptyList;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;
    private final FeignBookClient bookClient;

    public String save(AuthorRequest request) {
        //  TODO: create a mapper class
        Author author = convertToEntity(request);

        repository.save(author);
        return "successful registration";
    }

    private Author convertToEntity(AuthorRequest request) {
        return Author.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public AuthorDTO findAuthorById(int id, boolean findBooks) {
        Author author = repository.findById(id).orElseThrow(AuthorNotFoundException::new);

        //  TODO: create a mapper class
        AuthorDTO dto = convertToDTO(author);

        if (!findBooks) {
            return dto;
        }

        return dto.setBooks(bookClient.getBookByAuthorId(id).getBody());
    }

    private AuthorDTO convertToDTO(Author author) {
        return AuthorDTO.builder()
                .name(author.getName())
                .lastName(author.getLastName())
                .age(author.getAge())
                .createdAt(author.getCreatedAt())
                .books(emptyList())
                .build();
    }

}
