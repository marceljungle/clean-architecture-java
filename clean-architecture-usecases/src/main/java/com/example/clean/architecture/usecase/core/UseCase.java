package com.example.clean.architecture.usecase.core;

import com.example.clean.architecture.domain.core.Validation;
import com.example.clean.architecture.domain.core.Either;

public interface UseCase<T extends UseCaseParams, R> {

  Either<Validation, R> execute(T params);
}
