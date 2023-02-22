package com.example.clean.architecture.usecase.core;

import com.example.clean.architecture.domain.core.Either;
import com.example.clean.architecture.domain.core.Validation;

public interface UseCase<T extends UseCaseParams, R> {

  Either<Validation, R> execute(T params);
}
