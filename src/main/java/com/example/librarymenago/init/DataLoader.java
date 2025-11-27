package com.example.librarymenago.init;

import com.example.librarymenago.entities.Author;
import com.example.librarymenago.entities.Role;
import com.example.librarymenago.entities.User;
import com.example.librarymenago.repositories.AuthorRepository;
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
    private final AuthorRepository authorRepository;


    public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthorRepository authorRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
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

            if (authorRepository.count() == 0) {
                Author author1 = new Author("Adam", "Mickiewicz", "Polski poeta romantyczny, autor Pana Tadeusza.");
                Author author2 = new Author("Henryk", "Sienkiewicz", "Laureat Nobla, autor Quo Vadis i Trylogii.");
                Author author3 = new Author("Bolesław", "Prus", "Mistrz powieści pozytywistycznej, autor Lalki.");
                Author author4 = new Author("Eliza", "Orzeszkowa", "Pionierka feminizmu w literaturze, Nad Niemnem.");
                Author author5 = new Author("Stanisław", "Reymont", "Laureat Nobla, autor Chłopów.");
                Author author6 = new Author("Witold", "Gombrowicz", "Nowator prozy, autor Ferdydurke.");
                Author author7 = new Author("Czesław", "Miłosz", "Laureat Nobla w literaturze, Zniewolony umysł.");
                Author author8 = new Author("Wisława", "Szymborska", "Laureatka Nobla, poetka codzienności.");
                Author author9 = new Author("Tadeusz", "Różewicz", "Poeta i dramaturg XX wieku.");
                Author author10 = new Author("Olga", "Tokarczuk", "Laureatka Nobla, autorka Prowadź swój pług przez kości umarłych.");

                authorRepository.saveAll(List.of(author1, author2, author3, author4, author5,
                        author6, author7, author8, author9, author10));
                System.out.println("Authors saved");
            }



        }


    }


}
