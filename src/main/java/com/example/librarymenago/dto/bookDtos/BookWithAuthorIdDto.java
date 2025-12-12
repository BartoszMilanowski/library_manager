package com.example.librarymenago.dto.bookDtos;

import java.util.List;

public record BookWithAuthorIdDto(
        int id,
        String title,
        String description,
        String cover,
        Long isbn,
        List<Integer> authorsId
) {}
