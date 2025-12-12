package com.example.librarymenago.dto;

public record BookCopyToRentDto(
        int id,
        int bookId,
        String bookTitle,
        String barcode
) {}
