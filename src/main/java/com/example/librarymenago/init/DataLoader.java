package com.example.librarymenago.init;

import com.example.librarymenago.entities.Role;
import com.example.librarymenago.entities.User;
import com.example.librarymenago.repositories.UserRepository;
import com.example.librarymenago.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {

            User user1 = new User("admin1@example.com", passwordEncoder.encode("pass1"), "Jan", "Kowalski", Role.ADMIN);
            User user2 = new User("admin2@example.com", passwordEncoder.encode("pass2"), "Anna", "Nowak", Role.ADMIN);
            User user3 = new User("user1@example.com", passwordEncoder.encode("pass3"), "Piotr", "Wiśniewski", Role.USER);
            User user4 = new User("user2@example.com", passwordEncoder.encode("pass4"), "Katarzyna", "Zielińska", Role.USER);
            User user5 = new User("user3@example.com", passwordEncoder.encode("pass5"), "Michał", "Kaczmarek", Role.USER);

            userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
            System.out.println("User has been saved");
        }


    }


}
