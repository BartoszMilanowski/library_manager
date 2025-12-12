package com.example.librarymenago.controllers;

import com.example.librarymenago.dto.rentDtos.RentByUserDto;
import com.example.librarymenago.dto.rentDtos.RentDto;
import com.example.librarymenago.services.RentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {

    private RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping
    public List<RentDto> findAll() {
        return rentService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<RentByUserDto> findByUserId(@PathVariable int userId) {
        return rentService.findRentDtoByUserId(userId);
    }





}
