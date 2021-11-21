package guru.ysy.sdjpaintro.bootstrap;

import guru.ysy.sdjpaintro.domain.Book;
import guru.ysy.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by zhenrui on 2021/11/15 21:29
 */
@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        try {
            bookRepository.deleteAll();

            Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");

            System.out.println("Id: " + bookDDD.getId());

            Book savedDDD = bookRepository.save(bookDDD);

            System.out.println("Id: " + savedDDD.getId());

            Book bookSIA = new Book("Spring In Action", "234", "Orielly");
            Book savedSIA = bookRepository.save(bookSIA);

            System.out.println("Id: " + savedSIA.getId());
            System.out.println("**********************");

            bookRepository.findAll().forEach(book -> {
                System.out.println("Book Id: " + book.getId());
                System.out.println("Book Title: " + book.getTitle());
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }

    }
}
