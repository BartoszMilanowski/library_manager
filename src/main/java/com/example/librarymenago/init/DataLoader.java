package com.example.librarymenago.init;

import com.example.librarymenago.entities.Author;
import com.example.librarymenago.entities.Book;
import com.example.librarymenago.entities.Role;
import com.example.librarymenago.entities.User;
import com.example.librarymenago.repositories.AuthorRepository;
import com.example.librarymenago.repositories.BookRepository;
import com.example.librarymenago.repositories.UserRepository;
import com.example.librarymenago.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        if (authorRepository.count() == 0 && bookRepository.count() == 0) {
            // Tworzenie autorów (jak wcześniej)
            Author mickiewicz = new Author("Adam", "Mickiewicz", "Polski poeta romantyczny.");
            Author sienkiewicz = new Author("Henryk", "Sienkiewicz", "Laureat Nobla.");
            Author prus = new Author("Bolesław", "Prus", "Autor Lalki.");
            Author orzeszkowa = new Author("Eliza", "Orzeszkowa", "Nad Niemnem.");
            Author reymont = new Author("Stanisław", "Reymont", "Chłopi.");
            Author gombrowicz = new Author("Witold", "Gombrowicz", "Ferdydurke.");
            Author milosz = new Author("Czesław", "Miłosz", "Laureat Nobla.");
            Author szymborska = new Author("Wisława", "Szymborska", "Poetka Noblistka.");
            Author rozewicz = new Author("Tadeusz", "Różewicz", "Poeta XX wieku.");
            Author tokarczuk = new Author("Olga", "Tokarczuk", "Laureatka Nobla.");

            // Zapisz autorów (książki zapiszą się przez cascade)
            List<Author> authors = List.of(mickiewicz, sienkiewicz, prus, orzeszkowa, reymont, gombrowicz, milosz, szymborska, rozewicz, tokarczuk);
            authorRepository.saveAll(authors);

            // Książki z przypisanymi autorami
            Book book1 = new Book("Pan Tadeusz", "Epopeja narodowa", "pan_tadeusz.jpg", 9788370209557L, Set.of(mickiewicz));
            Book book2 = new Book("Dziady", "Dramat romantyczny", "dziady.jpg", 9788307017773L, Set.of(mickiewicz));

            Book book3 = new Book("Quo Vadis", "Powieść historyczna o Nerona", "quo_vadis.jpg", 9788370200134L, Set.of(sienkiewicz));
            Book book4 = new Book("Potop", "Trylogia - część II", "potop.jpg", 9788370200141L, Set.of(sienkiewicz));

            Book book5 = new Book("Lalka", "Powieść pozytywistyczna", "lalka.jpg", 9788370200158L, Set.of(prus));
            Book book6 = new Book("Faraon", "Powieść o starożytnym Egipcie", "faraon.jpg", 9788370200165L, Set.of(prus));

            Book book7 = new Book("Nad Niemnem", "Powieść patriotyczna", "nad_niemnem.jpg", 9788370200172L, Set.of(orzeszkowa));

            Book book8 = new Book("Chłopi", "Tetralogia wiejska, Nobel 1924", "chlopi.jpg", 9788370200189L, Set.of(reymont));

            Book book9 = new Book("Ferdydurke", "Powieść awangardowa", "ferdydurke.jpg", 9788370200196L, Set.of(gombrowicz));

            Book book10 = new Book("Zniewolony umysł", "Esej polityczny, Nobel 1980", "zniewolony_umysl.jpg", 9788370200202L, Set.of(milosz));

            Book book11 = new Book("Wołanie wołosza", "Poezja, Nobel 1996", "wolanie_wołosza.jpg", 9788370200219L, Set.of(szymborska));

            Book book12 = new Book("Prowadź swój pług przez kości umarłych", "Ekothriller, Nobel 2018", "plow_przez_kosci.jpg", 9788360067890L, Set.of(tokarczuk));

            List<Book> books = List.of(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12);



            bookRepository.saveAll(books);

            System.out.println("Books and authors saved");
        }


    }


}



