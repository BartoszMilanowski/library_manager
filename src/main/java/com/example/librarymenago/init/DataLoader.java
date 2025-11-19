package com.example.librarymenago.init;

import com.example.librarymenago.entities.*;
import com.example.librarymenago.repositories.AuthorRepository;
import com.example.librarymenago.repositories.BookRepository;
import com.example.librarymenago.repositories.TitleRepository;
import com.example.librarymenago.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final TitleRepository titleRepository;

    public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository, BookRepository bookRepository, AuthorRepository authorRepository, TitleRepository titleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.titleRepository = titleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Autorzy
        Author author1 = new Author("Jan", "Kowalski", "Bio autorski 1", new HashSet<>());
        Author author2 = new Author("Anna", "Nowak", "Bio autorski 2", new HashSet<>());

        authorRepository.save(author1);
        authorRepository.save(author2);

        // Tytuły i powiązani autorzy
        Title title1 = new Title("Spring Boot in Action", "Książka o Spring Boot", "cover1.png",
                new HashSet<>(Set.of(author1, author2)), 9788375400001L);
        Title title2 = new Title("Hibernate Basics", "Podstawy Hibernate", "cover2.png",
                new HashSet<>(Set.of(author1)), 9788375400002L);

        titleRepository.save(title1);
        titleRepository.save(title2);

        // Synchronizacja ManyToMany autorów i tytułów
        author1.getTitles().add(title1);
        author1.getTitles().add(title2);
        author2.getTitles().add(title1);

        authorRepository.save(author1);
        authorRepository.save(author2);

        // Książki do tytułów
        Book book1 = new Book(title1);
        book1.setIsRent(false);
        book1.setIsReserved(false);

        Book book2 = new Book(title1);
        book2.setIsRent(true);
        book2.setIsReserved(false);

        Book book3 = new Book(title2);
        book3.setIsRent(false);
        book3.setIsReserved(true);

        bookRepository.saveAll(List.of(book1, book2, book3));

        // Dodanie użytkowników
        User user1 = new User("jan.kowalski@example.com", passwordEncoder.encode("password123"), "Jan", "Kowalski", Role.USER);
        User user2 = new User("admin@example.com", passwordEncoder.encode("adminpass"), "Admin", "Adminowski", Role.ADMIN);

        userRepository.save(user1);
        userRepository.save(user2);
    }

}
