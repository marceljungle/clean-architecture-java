package com.example.clean.architecture.usecase.core.validation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidationSupport {

  private static final ValidationResult valid = new ValidationResult() {
    public boolean isValid() {
      return true;
    }

    public Optional<List<String>> getReasons() {
      return Optional.empty();
    }
  };

  private ValidationSupport() {
  }

  static ValidationResult valid() {
    return valid;
  }

  public static ValidationResult zip(final ValidationResult left, final ValidationResult right) {
    if (left.isValid() && right.isValid()) {
      return valid();
    } else {
      return ValidationResult.invalid(
          concat(left.getReasons(), right.getReasons()).flatMap(List::stream)
              .collect(Collectors.toList()));
    }
  }

  public static Stream<List<String>> concat(final Optional<List<String>> leftReasons,
      final Optional<List<String>> rightReason) {
    return Stream.concat(toStream(leftReasons), toStream(rightReason));
  }

  public static <T> Stream<T> toStream(final Optional<T> optional) {
    return optional.map(Stream::of).orElseGet(Stream::empty);
  }

}
