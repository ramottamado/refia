package codes.tamado.refia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * DTO for status response.
 *
 * @param status status code
 * @param reason reason for status code
 */
public record StatusDto(
    String status,
    @JsonInclude(Include.NON_EMPTY) String reason
) {
  public StatusDto(final String status) {
    this(status, null);
  }
}
