package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent,Integer> {

    List<Rent> findAll();
    List<Rent> findByUserId(Integer userId);
    List<Rent> findByBookCopyId(Integer bookCopyId);
}