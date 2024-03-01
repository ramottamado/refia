package codes.tamado.refia.entity;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import codes.tamado.refia.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "author", schema = "public")
public class Author extends BaseEntity {
  @Column(name = "first_name", nullable = false) private String firstName;

  @Column(name = "last_name", nullable = false) private String lastName;

  @ManyToMany(mappedBy = "authors") private Set<Book> books = new LinkedHashSet<>();

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
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

  @Override
  public final boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    Class<?> oEffectiveClass = o instanceof HibernateProxy
        ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
        : o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy
        ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass()
        : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) {
      return false;
    }
    final Author author = (Author) o;
    return getId() != null && Objects.equals(getId(), author.getId());
  }
}