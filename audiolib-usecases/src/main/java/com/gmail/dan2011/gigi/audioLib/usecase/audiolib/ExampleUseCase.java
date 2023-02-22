package com.gmail.dan2011.gigi.audioLib.usecase.audiolib;

import static com.gmail.dan2011.gigi.audioLib.domain.core.Either.left;
import static com.gmail.dan2011.gigi.audioLib.domain.core.Either.right;

import com.gmail.dan2011.gigi.audioLib.domain.core.Either;
import com.gmail.dan2011.gigi.audioLib.domain.core.Validation;
import com.gmail.dan2011.gigi.audioLib.usecase.audiolib.params.ExampleUseCaseParams;
import com.gmail.dan2011.gigi.audioLib.usecase.core.UseCase;
import com.gmail.dan2011.gigi.audioLib.usecase.response.VoidResponse;

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
