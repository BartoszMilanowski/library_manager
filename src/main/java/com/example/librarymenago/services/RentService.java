package com.example.librarymenago.services;

import com.example.librarymenago.dto.bookDtos.BookCopyToRentDto;
import com.example.librarymenago.dto.rentDtos.RentByUserDto;
import com.example.librarymenago.dto.rentDtos.RentDto;
import com.example.librarymenago.dto.userDtos.UserDto;
import com.example.librarymenago.entities.Rent;
import com.example.librarymenago.repositories.RentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    private RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public List<RentDto> findAll() {
        return rentRepository.findAll().stream()
                .map(rent -> new RentDto(
                        rent.getId(),
                        new UserDto(
                                rent.getUser().getId(),
                                rent.getUser().getEmail(),
                                rent.getUser().getFirstName(),
                                rent.getUser().getLastName()
                        ),
                        new BookCopyToRentDto(
                                rent.getBookCopy().getId(),
                                rent.getBookCopy().getBook().getId(),
                                rent.getBookCopy().getBook().getTitle(),
                                rent.getBookCopy().getBarcode()
                        ),
                        rent.getRentDate(),
                        rent.getReturnDate(),
                        rent.getStatus()
                ))
                .toList();
    }

    public List<Rent> findByUserId(Integer userId) {
        return rentRepository.findByUserId(userId);
    }

    public List<RentByUserDto> findRentDtoByUserId(Integer userId) {
        return rentRepository.findByUserId(userId).stream()
                .map(rent -> new RentByUserDto(
                        rent.getId(),
                        new BookCopyToRentDto(
                                rent.getBookCopy().getId(),
                                rent.getBookCopy().getBook().getId(),
                                rent.getBookCopy().getBook().getTitle(),
                                rent.getBookCopy().getBarcode()
                        ),
                        rent.getRentDate(),
                        rent.getReturnDate(),
                        rent.getStatus()
                )).toList();
    }

}
