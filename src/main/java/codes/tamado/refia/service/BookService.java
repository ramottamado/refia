package codes.tamado.refia.service;

import java.util.List;

import codes.tamado.refia.dto.BookDto;
import codes.tamado.refia.entity.Book;
import codes.tamado.refia.mapper.BookMapper;
import codes.tamado.refia.repository.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final BookRepository repository;
  private final BookMapper mapper;


  @Autowired
  public BookService(final BookRepository repository, final BookMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public @NotNull Object handleError() {
    return new Object() {
      public final String status = "Not found.";
    };
  }

  public @NotNull Object handleException(@NotNull Exception e) {
    return new Object() {
      public final String status = "Error.";
      public final String reason = e.getMessage();
    };
  }

  public List<BookDto> findBook(String title) {
    return repository.findByTitle(title).stream().map(mapper::toDto).toList();
  }

  public List<BookDto> findBook(Long year) {
    return repository.findByYear(year).stream().map(mapper::toDto).toList();
  }

  public BookDto addNewBook(BookDto bookDto) {
    Book book = mapper.toEntity(bookDto);
    Book result = repository.save(book);

    return mapper.toDto(result);
  }

  public void deleteBook(String code) {
    // BookDto bookDto = mapper.toDto(
    //     repository.findById(code).orElseThrow(() -> new RuntimeException("Book not found.")));

    repository.deleteById(code);
  }
}