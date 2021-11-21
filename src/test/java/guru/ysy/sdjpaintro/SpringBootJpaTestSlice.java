package guru.ysy.sdjpaintro;

import guru.ysy.sdjpaintro.domain.Book;
import guru.ysy.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by zhenrui on 2021/11/20 18:41
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"guru.ysy.sdjpaintro.bootstrap"})//bring in the bootstrap class for test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

//    @Rollback(value = false)//stop rollback so that the state can be passed on to the next test
    @Commit//This is cleaner than @Rollback
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My Book", "1234567", "Self"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
