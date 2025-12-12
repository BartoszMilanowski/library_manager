package com.example.librarymenago.dto.bookDtos;

import com.example.librarymenago.dto.authorDtos.AuthorBasicsDto;

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
