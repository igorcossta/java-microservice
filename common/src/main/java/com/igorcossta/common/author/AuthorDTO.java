package com.igorcossta.common.author;

import com.igorcossta.common.book.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {
    private String name;
    private String lastName;
    private Integer age;
    private LocalDateTime createdAt;
    private List<BookDTO> books;
}
