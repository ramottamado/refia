package codes.tamado.refia.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import org.jetbrains.annotations.NotNull;

@MappedSuperclass
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  @NotNull
  private Long id;

  public @NotNull Long getId() {
    return id;
  }

  public void setId(@NotNull Long id) {
    this.id = id;
  }
}