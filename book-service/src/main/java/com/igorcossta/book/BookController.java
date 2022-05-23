package com.igorcossta.book;

import com.igorcossta.common.book.BookDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBookByAuthorId(@RequestParam int author) {
        List<BookDTO> allBooksOfAuthorId = bookService.findAllByAuthorId(author);
        return ResponseEntity.ok(allBooksOfAuthorId);
    }

}
