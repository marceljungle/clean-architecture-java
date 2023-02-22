package com.example.clean.architecture.usecase.audiolib;

import static com.example.clean.architecture.domain.core.Either.left;
import static com.example.clean.architecture.domain.core.Either.right;

import com.example.clean.architecture.domain.core.Validation;
import com.example.clean.architecture.usecase.core.UseCase;
import com.example.clean.architecture.domain.core.Either;
import com.example.clean.architecture.usecase.audiolib.params.ExampleUseCaseParams;
import com.example.clean.architecture.usecase.response.VoidResponse;

public class ExampleUseCase implements UseCase<ExampleUseCaseParams, VoidResponse> {

  @Override
  public Either<Validation, VoidResponse> execute(final ExampleUseCaseParams params) {
    final Validation notificationErrors = params.validate();
    if (notificationErrors.hasErrors()) {
      return left(notificationErrors);
    } else {
      return right(this.doAction());
    }
  }

  private VoidResponse doAction() {
    return VoidResponse.ok();
  }
}
