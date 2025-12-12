package com.example.librarymenago.dto;

import java.util.Set;

public record BookWithCopiesDto(
        int bookId,
        String title,
        String description,
        String cover,
        Long isbn,
        Set<AuthorBasicsDto> authors,
        Set<BookCopiesDto> copies
) {}
