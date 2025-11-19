package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title,Integer> {
}
