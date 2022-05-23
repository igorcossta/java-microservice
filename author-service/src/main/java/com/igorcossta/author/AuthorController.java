package com.igorcossta.author;

import com.igorcossta.common.author.AuthorDTO;
import com.igorcossta.common.author.AuthorRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorRequest request) {
        String save = authorService.save(request);
        return ResponseEntity.ok(save);
    }

    @GetMapping
    public ResponseEntity<AuthorDTO> get(@RequestParam(defaultValue = "1") int id,
                                         @RequestParam(defaultValue = "false") boolean findBooks) {
        AuthorDTO author = authorService.findAuthorById(id, findBooks);
        return ResponseEntity.ok(author);
    }
}
