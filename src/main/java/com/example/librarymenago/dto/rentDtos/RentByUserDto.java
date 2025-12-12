package com.example.librarymenago.dto.rentDtos;

import com.example.librarymenago.dto.bookDtos.*;
import com.example.librarymenago.entities.Rent;

import java.time.LocalDate;

public record RentByUserDto(
        int id,
        BookCopyToRentDto bookCopyToRentDto,
        LocalDate rentDate,
        LocalDate returnDate,
        Rent.RentStatus status
) {}
