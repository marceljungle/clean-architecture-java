package com.gmail.dan2011.gigi.audioLib.usecase.core;

import com.gmail.dan2011.gigi.audioLib.domain.core.Either;
import com.gmail.dan2011.gigi.audioLib.domain.core.Validation;

public interface UseCase<T extends UseCaseParams, R> {

  Either<Validation, R> execute(T params);
}
