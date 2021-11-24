package guru.ysy.sdjpaintro.repositories;

import guru.ysy.sdjpaintro.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhenrui on 2021/11/24 18:52
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
