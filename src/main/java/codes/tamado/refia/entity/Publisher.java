package codes.tamado.refia.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import codes.tamado.refia.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "publisher", schema = "public")
public class Publisher extends BaseEntity {
  @Column(name = "name", nullable = false, unique = true)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String name;

  @OneToMany(mappedBy = "publisher")
  private Set<Book> books = new LinkedHashSet<>();

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(final Set<Book> books) {
    this.books = books;
  }
}