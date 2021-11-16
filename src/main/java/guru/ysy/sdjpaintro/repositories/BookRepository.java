package guru.ysy.sdjpaintro.repositories;

import guru.ysy.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhenrui on 2021/11/15 21:27
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
