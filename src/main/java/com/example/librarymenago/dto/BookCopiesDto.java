package com.example.librarymenago.dto;

public record BookCopiesDto(
        int id,
        String barcode,
        com.example.librarymenago.entities.BookCopyStatus status
) {}
