package com.macu.template;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class TestObject {

  private long id;

  @NotNull
  @NotBlank
  @Size(max = 8)
  private String name;
}
