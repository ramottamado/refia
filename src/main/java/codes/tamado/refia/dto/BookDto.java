package codes.tamado.refia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO for {@link codes.tamado.refia.entity.Book}
 *
 * @param code          book code
 * @param title         book title
 * @param categoryName  category name
 * @param publisherName publisher name
 * @param authors       authors
 * @param year          year of publication
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDto(
    @NotBlank String code,
    @NotBlank String title,
    @NotBlank String categoryName,
    @NotBlank String publisherName,
    @NotNull @Size(min = 1) Set<AuthorDto> authors,
    @NotNull Long year) implements Serializable {

  /**
   * DTO for {@link codes.tamado.refia.entity.Author}
   *
   * @param name author name
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public record AuthorDto(String name) implements Serializable {}
}