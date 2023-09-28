package codes.tamado.refia.repository;

import java.util.List;

import codes.tamado.refia.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
  List<Book> findByYear(Long year);

  List<Book> findByTitle(String title);
}