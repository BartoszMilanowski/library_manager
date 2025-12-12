package com.example.librarymenago.dto.bookDtos;

public record BookCopyToRentDto(
        int id,
        int bookId,
        String bookTitle,
        String barcode
) {}
