package com.example.clean.architecture.usecase.audiolib.params;

import com.example.clean.architecture.domain.core.Validation;
import com.example.clean.architecture.usecase.audiolib.params.validate.UseCaseParamsValidation;
import com.example.clean.architecture.usecase.core.UseCaseParams;
import com.example.clean.architecture.usecase.core.validation.ValidationResult;
import java.util.Objects;
import lombok.Getter;

@Getter
public class ExampleUseCaseParams implements UseCaseParams {

  private final String message;

  public ExampleUseCaseParams(final String message) {
    this.message = message;
  }

  @Override
  public Validation validate() {
    final var validation = new Validation();
    final ValidationResult result;
    result = UseCaseParamsValidation.fullParametersValidations().apply(this.message);
    result.getReasons().ifPresent(validation::addErrors);
    return validation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExampleUseCaseParams that = (ExampleUseCaseParams) o;
    return Objects.equals(message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    return "ExampleUseCaseParams{"
        + "message='" + message + '\''
        + '}';
  }
}