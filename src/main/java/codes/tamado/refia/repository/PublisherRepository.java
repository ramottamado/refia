package codes.tamado.refia.repository;

import java.util.Optional;

import codes.tamado.refia.entity.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
  Optional<Publisher> findByName(String name);
}