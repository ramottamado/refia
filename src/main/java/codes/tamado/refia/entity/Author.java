package codes.tamado.refia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

import codes.tamado.refia.entity.base.BaseEntity;

import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "author", schema = "public")
public class Author extends BaseEntity {
  @Column(name = "name", nullable = false, unique = true) private String name;

  @ManyToMany(mappedBy = "authors") private Set<Book> books = new LinkedHashSet<>();

  public String getName() {
    return name;
  }

  public void setName(final String firstName) {
    this.name = firstName;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(final Set<Book> books) {
    this.books = books;
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass().hashCode() : getClass().hashCode();
  }
}