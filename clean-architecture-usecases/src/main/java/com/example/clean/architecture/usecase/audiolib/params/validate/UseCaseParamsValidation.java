package com.example.clean.architecture.usecase.audiolib.params.validate;

import static com.example.clean.architecture.usecase.core.validation.ValidationResult.invalid;

import com.example.clean.architecture.usecase.core.validation.ValidationResult;
import com.example.clean.architecture.usecase.core.validation.ValidationSupport;
import java.util.function.Function;
import java.util.function.Predicate;

public interface UseCaseParamsValidation extends Function<String, ValidationResult> {

  static UseCaseParamsValidation messageContainsAction() {
    return holds(s -> s.contains("action"), "Action not provided.");
  }

  static UseCaseParamsValidation messageIsNotEmpty() {
    return holds(s -> s != null && !s.isEmpty(), "Empty message.");
  }

  static UseCaseParamsValidation fullParametersValidations() {
    return messageIsNotEmpty().and(messageContainsAction());
  }

  private static UseCaseParamsValidation holds(final Predicate<String> p, final String message) {
    return input -> p.test(input) ? ValidationResult.valid() : ValidationResult.invalid(message);
  }

  default UseCaseParamsValidation and(final UseCaseParamsValidation other) {
    return params -> ValidationSupport.zip(this.apply(params), other.apply(params));
  }
}