package com.example.librarymenago.dto;

import com.example.librarymenago.entities.Rent;

import java.time.LocalDate;

public record RentDto(
       int id,
       UserDto user,
       BookCopyToRentDto bookCopies,
       LocalDate rentDate,
       LocalDate returnDate,
       Rent.RentStatus status
) {}
