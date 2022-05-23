package com.igorcossta.common.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    private String name;
    private String lastName;
    private Integer age;
    private LocalDateTime createdAt;

}
