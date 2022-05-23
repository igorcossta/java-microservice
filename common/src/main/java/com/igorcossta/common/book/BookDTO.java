package com.igorcossta.common.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private String name;
    private String description;
    private LocalDateTime publishedAt;
    private String country;
    private Integer authorId;
}
