package codes.tamado.refia.repository;

import java.util.Optional;

import codes.tamado.refia.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  Optional<Category> findByName(String name);
}