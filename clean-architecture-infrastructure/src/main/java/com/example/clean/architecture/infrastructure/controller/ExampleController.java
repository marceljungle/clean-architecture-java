package com.example.clean.architecture.infrastructure.controller;

import com.example.clean.architecture.domain.core.Either;
import com.example.clean.architecture.domain.core.Validation;
import com.example.clean.architecture.domain.services.ExampleService;
import com.example.clean.architecture.usecase.audiolib.params.ExampleUseCaseParams;
import com.example.clean.architecture.usecase.core.UseCase;
import com.example.clean.architecture.usecase.response.VoidResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ExampleController implements ExampleService {

  private final UseCase<ExampleUseCaseParams, VoidResponse> useCaseNotification;

  public ExampleController(final UseCase<ExampleUseCaseParams, VoidResponse> exampleUseCase) {
    this.useCaseNotification = exampleUseCase;
  }

  @Override
  public String execute(final String message) {
    final Either<Validation, VoidResponse> responses = this.useCaseNotification.execute(
        this.toParams(message));
    if (responses.isRight()) {
      return message;
    } else {
      responses.getLeft().getErrors().forEach(log::error);
      return "ERROR";
    }
  }

  private ExampleUseCaseParams toParams(final String message) {
    return new ExampleUseCaseParams(message);
  }
}