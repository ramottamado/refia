package codes.tamado.refia.entity;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "book", schema = "public")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private Long id;

  @Column(name = "code", nullable = false, unique = true)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String code;

  @Column(name = "title", nullable = false)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String title;

  @ManyToOne(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  }, optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @ManyToOne(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  }, optional = false)
  @JoinColumn(name = "publisher_id", nullable = false)
  private Publisher publisher;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "book_authors",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "authors_id"))
  private Set<Author> authors = new LinkedHashSet<>();

  @Column(name = "year_", nullable = false) private Long year;

  @CreationTimestamp
  @Column(name = "insert_date", nullable = false)
  private Instant insertDate;

  public Long getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(final Category category) {
    this.category = category;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(final Publisher publisher) {
    this.publisher = publisher;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(final Set<Author> authors) {
    this.authors = authors;
  }

  public Long getYear() {
    return year;
  }

  public void setYear(final Long year) {
    this.year = year;
  }

  public Instant getInsertDate() {
    return insertDate;
  }

  public void setInsertDate(final Instant insertDate) {
    this.insertDate = insertDate;
  }
}