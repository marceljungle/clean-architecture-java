package com.gmail.dan2011.gigi.audioLib.usecase.core.validation;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ValidationResult {

  static ValidationResult valid() {
    return ValidationSupport.valid();
  }

  static ValidationResult invalid(final List<String> reasons) {
    return new Invalid(reasons);
  }

  static ValidationResult invalid(final String reason, final String... reasons) {
    final List<String> reasonList = new ArrayList<>();
    reasonList.add(reason);
    reasonList.addAll(asList(reasons));
    return new Invalid(reasonList);
  }

  boolean isValid();

  Optional<List<String>> getReasons();

}
