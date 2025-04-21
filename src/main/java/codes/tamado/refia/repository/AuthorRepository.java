package codes.tamado.refia.repository;

import java.util.Optional;

import codes.tamado.refia.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  Optional<Author> findByName(String name);
}