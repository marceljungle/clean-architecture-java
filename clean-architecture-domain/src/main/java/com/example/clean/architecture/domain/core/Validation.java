package com.example.clean.architecture.domain.core;

import static com.example.clean.architecture.domain.core.Either.left;
import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Validation {

  private final List<String> errors;

  public Validation() {
    this.errors = new ArrayList<>();
  }

  public static Validation empty() {
    return new Validation();
  }

  public static Validation of(final Throwable error) {
    final Validation validation = new Validation();
    validation.addError(error.getMessage());
    return validation;
  }

  public static Validation of(final String error) {
    final Validation validation = new Validation();
    validation.addError(error);
    return validation;
  }

  public List<String> getErrors() {
    return unmodifiableList(this.errors);
  }

  public void addError(final String error) {
    this.errors.add(error);
  }

  public void addErrors(final List<String> error) {
    this.errors.addAll(error);
  }

  public boolean hasErrors() {
    return !this.errors.isEmpty();
  }

  public <T extends RuntimeException> T as(final Function<List<String>, T> supplier) {
    return supplier.apply(this.getErrors());
  }

  public Validation or(final Supplier<Validation> s) {
    if (this.hasErrors()) {
      return this;
    } else {
      return s.get();
    }
  }

  public <T extends RuntimeException> Validation orElseThrow(final Supplier<Validation> s1,
      final Function<List<String>, T> s2) {
    if (this.hasErrors()) {
      throw s2.apply(this.getErrors());
    } else {
      return s1.get();
    }
  }

  public <T> Either<Validation, T> asEither() {
    return left(this);
  }
}
