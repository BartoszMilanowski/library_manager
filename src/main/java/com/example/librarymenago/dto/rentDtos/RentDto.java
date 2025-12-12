package com.example.librarymenago.dto.rentDtos;

import com.example.librarymenago.dto.userDtos.UserDto;
import com.example.librarymenago.dto.bookDtos.BookCopyToRentDto;
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
