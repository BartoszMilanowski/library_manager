package com.example.librarymenago.dto;

import java.util.Set;

public record BookDto(
        int id,
        String title,
        String description,
        String cover,
        Long isbn,
        Set<AuthorBasicsDto> authors
) {
}
