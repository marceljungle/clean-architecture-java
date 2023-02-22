package com.example.clean.architecture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.clean.architecture.domain.core.Either;
import com.example.clean.architecture.domain.core.Validation;
import com.example.clean.architecture.usecase.audiolib.ExampleUseCase;
import com.example.clean.architecture.usecase.audiolib.params.ExampleUseCaseParams;
import com.example.clean.architecture.usecase.response.VoidResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExampleUseCaseTest {

  @Test
  @DisplayName("Given valid params When use case is invoked Then return OK")
  void validCase() {
    // Given
    final ExampleUseCase exampleUseCase = new ExampleUseCase();
    final ExampleUseCaseParams params = new ExampleUseCaseParams("Action example message");

    // When
    final Either<Validation, VoidResponse> response = exampleUseCase.execute(params);

    // Then
    assertTrue(response.isRight());
    assertEquals(response.get(), VoidResponse.ok());
  }

  @Test
  @DisplayName("Given invalid params When use case is invoked Then return KO")
  void invalidCase1() {
    // Given
    final ExampleUseCase exampleUseCase = new ExampleUseCase();
    final ExampleUseCaseParams params = new ExampleUseCaseParams("");

    // When
    final Either<Validation, VoidResponse> response = exampleUseCase.execute(params);

    // Then
    assertTrue(response.isLeft());
  }

  @Test
  @DisplayName("Given invalid params When use case is invoked Then return KO 2")
  void invalidCase2() {
    // Given
    final ExampleUseCase exampleUseCase = new ExampleUseCase();
    final ExampleUseCaseParams params = new ExampleUseCaseParams("This is a message.");

    // When
    final Either<Validation, VoidResponse> response = exampleUseCase.execute(params);

    // Then
    assertTrue(response.isLeft());
  }
}