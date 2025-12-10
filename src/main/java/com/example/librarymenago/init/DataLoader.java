package com.example.librarymenago.init;

import com.example.librarymenago.entities.*;
import com.example.librarymenago.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Component
public class DataLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookCopyRepository bookCopyRepository;
    private final RentRepository rentRepository;


    public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthorRepository authorRepository, BookRepository bookRepository, BookCopyRepository bookCopyRepository, RentRepository rentRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.rentRepository = rentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
            User user2 = new User("admin2@example.com", passwordEncoder.encode("pass2"), "Anna", "Nowak", Role.ADMIN);
            User user1 = new User("admin1@example.com", passwordEncoder.encode("pass1"), "Jan", "Kowalski", Role.ADMIN);
            User user3 = new User("user1@example.com", passwordEncoder.encode("pass3"), "Piotr", "Wiśniewski", Role.USER);
            User user4 = new User("user2@example.com", passwordEncoder.encode("pass4"), "Katarzyna", "Zielińska", Role.USER);
            User user5 = new User("user3@example.com", passwordEncoder.encode("pass5"), "Michał", "Kaczmarek", Role.USER);

            userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
            System.out.println("Users have been saved");


            if (authorRepository.count() == 0 && bookRepository.count() == 0) {
                // Autorzy
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

                List<Author> authors = List.of(
                        mickiewicz, sienkiewicz, prus, orzeszkowa, reymont,
                        gombrowicz, milosz, szymborska, rozewicz, tokarczuk
                );
                authorRepository.saveAll(authors);

                // Książki
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

                Book book12 = new Book(
                        "Prowadź swój pług przez kości umarłych",
                        "Ekothriller, Nobel 2018",
                        "plow_przez_kosci.jpg",
                        9788360067890L,
                        Set.of(tokarczuk)
                );

                List<Book> books = List.of(
                        book1, book2, book3, book4, book5, book6,
                        book7, book8, book9, book10, book11, book12
                );

                bookRepository.saveAll(books);
                System.out.println("Books and authors saved");

                // Tworzenie egzemplarzy BookCopy
                // Pan Tadeusz - 5 egzemplarzy
                BookCopy copy1 = new BookCopy(book1, "PT-002", BookCopyStatus.AVAILABLE);
                BookCopy copy2 = new BookCopy(book1, "PT-003", BookCopyStatus.BORROWED);
                BookCopy copy3 = new BookCopy(book1, "PT-001", BookCopyStatus.AVAILABLE);
                BookCopy copy4 = new BookCopy(book1, "PT-004", BookCopyStatus.AVAILABLE);
                BookCopy copy5 = new BookCopy(book1, "PT-005", BookCopyStatus.DAMAGED);

                // Dziady - 3 egzemplarze
                BookCopy copy6 = new BookCopy(book2, "DZ-001", BookCopyStatus.AVAILABLE);
                BookCopy copy7 = new BookCopy(book2, "DZ-002", BookCopyStatus.AVAILABLE);
                BookCopy copy8 = new BookCopy(book2, "DZ-003", BookCopyStatus.BORROWED);

                // Quo Vadis - 4 egzemplarze
                BookCopy copy9 = new BookCopy(book3, "QV-001", BookCopyStatus.AVAILABLE);
                BookCopy copy10 = new BookCopy(book3, "QV-002", BookCopyStatus.AVAILABLE);
                BookCopy copy11 = new BookCopy(book3, "QV-003", BookCopyStatus.AVAILABLE);
                BookCopy copy12 = new BookCopy(book3, "QV-004", BookCopyStatus.BORROWED);

                // Potop - 3 egzemplarze
                BookCopy copy13 = new BookCopy(book4, "PO-001", BookCopyStatus.AVAILABLE);
                BookCopy copy14 = new BookCopy(book4, "PO-002", BookCopyStatus.DAMAGED);
                BookCopy copy15 = new BookCopy(book4, "PO-003", BookCopyStatus.AVAILABLE);

                // Lalka - 4 egzemplarze
                BookCopy copy16 = new BookCopy(book5, "LA-001", BookCopyStatus.AVAILABLE);
                BookCopy copy17 = new BookCopy(book5, "LA-002", BookCopyStatus.AVAILABLE);
                BookCopy copy18 = new BookCopy(book5, "LA-003", BookCopyStatus.BORROWED);
                BookCopy copy19 = new BookCopy(book5, "LA-004", BookCopyStatus.AVAILABLE);

                // Faraon - 2 egzemplarze
                BookCopy copy20 = new BookCopy(book6, "FA-001", BookCopyStatus.AVAILABLE);
                BookCopy copy21 = new BookCopy(book6, "FA-002", BookCopyStatus.BORROWED);

                // Pozostałe książki - po 2-3 egzemplarzach
                BookCopy copy22 = new BookCopy(book7, "NN-001", BookCopyStatus.AVAILABLE);
                BookCopy copy23 = new BookCopy(book7, "NN-002", BookCopyStatus.AVAILABLE);

                BookCopy copy24 = new BookCopy(book8, "CH-001", BookCopyStatus.AVAILABLE);
                BookCopy copy25 = new BookCopy(book8, "CH-002", BookCopyStatus.BORROWED);
                BookCopy copy26 = new BookCopy(book8, "CH-003", BookCopyStatus.AVAILABLE);

                BookCopy copy27 = new BookCopy(book9, "FE-001", BookCopyStatus.AVAILABLE);
                BookCopy copy28 = new BookCopy(book9, "FE-002", BookCopyStatus.AVAILABLE);

                BookCopy copy29 = new BookCopy(book10, "ZU-001", BookCopyStatus.AVAILABLE);
                BookCopy copy30 = new BookCopy(book10, "ZU-002", BookCopyStatus.DAMAGED);

                BookCopy copy31 = new BookCopy(book11, "WW-001", BookCopyStatus.AVAILABLE);
                BookCopy copy32 = new BookCopy(book11, "WW-002", BookCopyStatus.AVAILABLE);

                BookCopy copy33 = new BookCopy(book12, "PPK-001", BookCopyStatus.AVAILABLE);
                BookCopy copy34 = new BookCopy(book12, "PPK-002", BookCopyStatus.BORROWED);

                List<BookCopy> bookCopies = List.of(copy1, copy2, copy3, copy4, copy5,
                        copy6, copy7, copy8, copy9, copy10, copy11, copy12, copy13, copy14,
                        copy15, copy16, copy17, copy18, copy19, copy20,
                        copy21, copy22, copy23, copy24, copy25,
                        copy26, copy27, copy28, copy29, copy30,
                        copy31, copy32, copy33, copy34);

                bookCopyRepository.saveAll(bookCopies);
                System.out.println("Book copies initialized: " + bookCopies.size());

                LocalDateTime now = LocalDateTime.now();

                LocalDate date1 = LocalDate.now();
                LocalDate date2 = LocalDate.of(2025, 12, 04);
                LocalDate date3 = LocalDate.of(2025, 11, 05);
                LocalDate date4 = LocalDate.of(2025, 10, 06);
                LocalDate date5 = LocalDate.of(2025, 12, 10);
                LocalDate date6 = LocalDate.of(2025, 12, 4);
                LocalDate date7 = LocalDate.of(2025, 12, 10);

                Rent rent1 = new Rent(user3, copy2, date1, date1.plusDays(30), Rent.RentStatus.ACTIVE);
                Rent rent2 = new Rent(user4, copy8, date2, date2.plusDays(30), Rent.RentStatus.ACTIVE);
                Rent rent3 = new Rent(user5, copy12, date3, date3.plusDays(30), Rent.RentStatus.OVERDUE);
                Rent rent4 = new Rent(user3, copy18, date4, date4.plusDays(30), Rent.RentStatus.OVERDUE);
                Rent rent5 = new Rent(user3, copy21, date5, date5.plusDays(30), Rent.RentStatus.ACTIVE);
                Rent rent6 = new Rent(user5, copy25, date6, date6.plusDays(30), Rent.RentStatus.ACTIVE);
                Rent rent7 = new Rent(user5, copy34, date7, date7.plusDays(30), Rent.RentStatus.ACTIVE);

                List<Rent> rents = List.of(rent1, rent2, rent3, rent4, rent5, rent6, rent7);
                rentRepository.saveAll(rents);
                System.out.println("Rents initialized: " + rents.size());

            }
        }


    }
}



