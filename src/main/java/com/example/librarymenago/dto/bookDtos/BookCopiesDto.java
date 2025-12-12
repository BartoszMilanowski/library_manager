package com.example.librarymenago.dto.bookDtos;

import com.example.librarymenago.entities.BookCopyStatus;

public record BookCopiesDto(
        int id,
        String barcode,
        BookCopyStatus status
) {}
