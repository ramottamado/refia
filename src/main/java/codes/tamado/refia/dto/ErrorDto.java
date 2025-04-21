package codes.tamado.refia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * DTO for error response.
 *
 * @param status status code
 * @param reason error message
 */
public record ErrorDto(
    String status,
    @JsonInclude(Include.NON_EMPTY) String reason
) {}
