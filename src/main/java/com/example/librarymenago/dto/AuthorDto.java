package com.example.librarymenago.dto;

import java.util.Set;

public record AuthorDto(
        int id,
        String firstName,
        String lastName,
        String bio,
        Set<BookBasicDto> books
) {}
