package com.gmail.dan2011.gigi.audioLib.usecase.audiolib.params;

import com.gmail.dan2011.gigi.audioLib.domain.core.Validation;
import com.gmail.dan2011.gigi.audioLib.usecase.audiolib.params.validate.UseCaseParamsValidation;
import com.gmail.dan2011.gigi.audioLib.usecase.core.validation.ValidationResult;
import lombok.Getter;

@Getter
public class ExampleUseCaseParams implements com.gmail.dan2011.gigi.audioLib.usecase.core.UseCaseParams {

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
}