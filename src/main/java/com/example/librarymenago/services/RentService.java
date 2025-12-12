package com.example.librarymenago.services;

import com.example.librarymenago.dto.BookCopyToRentDto;
import com.example.librarymenago.dto.RentDto;
import com.example.librarymenago.dto.UserDto;
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
        return  rentRepository.findAll().stream()
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

    public Rent findById(Integer id) {
        return rentRepository.findById(id).get();
    }

    public List<Rent> findByBookCopyId(Integer bookCopyId) {
        return rentRepository.findByBookCopyId(bookCopyId);
    }

    public List<Rent> findByUserId(Integer userId) {
        return rentRepository.findByUserId(userId);
    }

}
