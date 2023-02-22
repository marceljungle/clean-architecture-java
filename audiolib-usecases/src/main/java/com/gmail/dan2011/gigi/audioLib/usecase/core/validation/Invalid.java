package com.gmail.dan2011.gigi.audioLib.usecase.core.validation;

import static java.util.Optional.of;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Invalid implements ValidationResult {

  private final List<String> reasons;

  Invalid(final List<String> reasons) {
    this.reasons = Collections.unmodifiableList(reasons);
  }

  @Override
  public boolean isValid() {
    return false;
  }

  @Override
  public Optional<List<String>> getReasons() {
    return of(this.reasons);
  }
}
