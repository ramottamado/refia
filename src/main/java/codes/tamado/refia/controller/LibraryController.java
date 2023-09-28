package codes.tamado.refia.controller;

import java.util.List;

import codes.tamado.refia.common.CommonReturnType;
import codes.tamado.refia.dto.BookDto;
import codes.tamado.refia.service.BookService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotBlank;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
@Validated
public class LibraryController {
  private final BookService service;

  @Autowired
  public LibraryController(final BookService service) {
    this.service = service;
  }

  @Hidden
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @RequestMapping(path = "/error")
  public @ResponseBody CommonReturnType<Object> handleError() {
    return CommonReturnType.create("Error.", service.handleError());
  }

  @Hidden
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommonReturnType<Object> handleException(Exception e) {
    return CommonReturnType.create("Error.", service.handleException(e));
  }

  @GetMapping(path = "/title")
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody CommonReturnType<List<BookDto>> titleHandler(
      @RequestParam String title) {
    return CommonReturnType.create(service.findBook(title));
  }

  @GetMapping(path = "/year")
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody CommonReturnType<List<BookDto>> yearHandler(
      @RequestParam Long year) {
    return CommonReturnType.create(service.findBook(year));
  }

  @PostMapping(path = "/addNewBook")
  @ResponseStatus(HttpStatus.CREATED)
  public @ResponseBody CommonReturnType<BookDto> addNewBook(
      @RequestBody @NotNull @Validated BookDto bookDto) {
    return CommonReturnType.create(service.addNewBook(bookDto));
  }

  @DeleteMapping(path = "/deleteBook/{code}")
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody CommonReturnType<Object> deleteBook(
      @PathVariable("code") @NotBlank @Validated String code) {
    service.deleteBook(code);

    return CommonReturnType.create("OK.");
  }
}
