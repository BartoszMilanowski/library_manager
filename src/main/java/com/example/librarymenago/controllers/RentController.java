package com.example.librarymenago.controllers;

import com.example.librarymenago.dto.RentDto;
import com.example.librarymenago.services.RentService;
import org.springframework.web.bind.annotation.GetMapping;
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



}
