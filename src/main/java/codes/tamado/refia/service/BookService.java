package codes.tamado.refia.service;

import java.util.LinkedHashSet;
import java.util.List;

import codes.tamado.refia.dto.BookDto;
import codes.tamado.refia.dto.StatusDto;
import codes.tamado.refia.entity.Book;
import codes.tamado.refia.mapper.BookMapper;
import codes.tamado.refia.repository.AuthorRepository;
import codes.tamado.refia.repository.BookRepository;
import codes.tamado.refia.repository.CategoryRepository;
import codes.tamado.refia.repository.PublisherRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final CategoryRepository categoryRepository;
  private final PublisherRepository publisherRepository;
  private final BookMapper mapper;


  @Autowired
  public BookService(
      final AuthorRepository authorRepository,
      final BookRepository bookRepository,
      final CategoryRepository categoryRepository,
      final PublisherRepository publisherRepository,
      final BookMapper mapper) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.categoryRepository = categoryRepository;
    this.publisherRepository = publisherRepository;
    this.mapper = mapper;
  }

  public @NotNull StatusDto handleError() {
    return new StatusDto("Not found.");
  }

  public @NotNull StatusDto handleException(@NotNull Exception e) {
    return new StatusDto("Error.", e.getMessage());
  }

  public List<BookDto> findBook(String title) {
    return bookRepository.findByTitle(title).stream().map(mapper::toDto).toList();
  }

  public List<BookDto> findBook(Long year) {
    return bookRepository.findByYear(year).stream().map(mapper::toDto).toList();
  }

  @Transactional
  public BookDto addNewBook(BookDto bookDto) {
    Book book = mapper.toEntity(bookDto);
    Book _book = new Book();

    _book.setCode(book.getCode());
    _book.setTitle(book.getTitle());
    _book.setYear(book.getYear());
    _book.setAuthors(new LinkedHashSet<>());

    _book.setCategory(book.getCategory());
    _book.setPublisher(book.getPublisher());

    categoryRepository.findByName(book.getCategory().getName())
        .ifPresent(_book::setCategory);

    publisherRepository.findByName(book.getPublisher().getName())
        .ifPresent(_book::setPublisher);

    book.getAuthors().stream()
        .map(author -> authorRepository
            .findByName(author.getName())
            .orElse(author))
        .forEach(author -> _book.getAuthors().add(author));

    Book result = bookRepository.save(_book);

    return mapper.toDto(result);
  }

  public void deleteBook(String code) {
    bookRepository.deleteById(code);
  }
}