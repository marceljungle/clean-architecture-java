package com.gmail.dan2011.gigi.audioLib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gmail.dan2011.gigi.audioLib.domain.core.Either;
import com.gmail.dan2011.gigi.audioLib.domain.core.Validation;
import com.gmail.dan2011.gigi.audioLib.usecase.audiolib.ExampleUseCase;
import com.gmail.dan2011.gigi.audioLib.usecase.audiolib.params.ExampleUseCaseParams;
import com.gmail.dan2011.gigi.audioLib.usecase.response.VoidResponse;
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