package com.igorcossta.book;

import com.igorcossta.common.book.BookDTO;
import com.igorcossta.common.exception.AuthorHasNoBookException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<BookDTO> findAllByAuthorId(int id) {
        Function<Book, BookDTO> convertToDto = i -> new BookDTO(
                i.getName(),
                i.getDescription(),
                i.getPublishedAt(),
                i.getCountry(),
                i.getAuthorId()
        );
        List<Book> allBooksOfAuthorId = repository.findAllByAuthorId(id);
        if (allBooksOfAuthorId.isEmpty()) throw new AuthorHasNoBookException();

        return allBooksOfAuthorId.stream().map(convertToDto).collect(Collectors.toList());
    }
}
