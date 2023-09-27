package codes.tamado.refia.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for {@link codes.tamado.refia.entity.Book}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDto(
    @NotNull @NotEmpty @NotBlank String code,
    @NotNull @NotEmpty @NotBlank String title,
    @NotNull @NotEmpty @NotBlank String categoryName,
    @NotNull @NotEmpty @NotBlank String publisherName,
    @NotNull @Size(min = 1) Set<AuthorDto> authors,
    @NotNull Long year) implements Serializable {
  /**
   * DTO for {@link codes.tamado.refia.entity.Author}
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public record AuthorDto(String firstName, String lastName) implements Serializable {}
}