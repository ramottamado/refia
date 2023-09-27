package codes.tamado.refia.common;

import codes.tamado.refia.common.serde.JsonSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

@JsonSerializable
public class CommonReturnType<T> {
  @JsonProperty private String status;
  @JsonProperty private T data;

  public static <T> @NotNull CommonReturnType<T> create(T data) {
    return create("Success.", data);
  }

  public static <T> @NotNull CommonReturnType<T> create(String status, T data) {
    CommonReturnType<T> type = new CommonReturnType<>();
    type.setStatus(status);
    type.setData(data);

    return type;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

  public T getData() {
    return data;
  }

  public void setData(final T data) {
    this.data = data;
  }
}