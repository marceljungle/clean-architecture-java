package com.gmail.dan2011.gigi.audioLib.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import com.gmail.dan2011.gigi.audioLib.Application;
import com.gmail.dan2011.gigi.audioLib.domain.audiolib.services.ExampleService;
import com.gmail.dan2011.gigi.audioLib.domain.core.Either;
import com.gmail.dan2011.gigi.audioLib.domain.core.Validation;
import com.gmail.dan2011.gigi.audioLib.usecase.audiolib.params.ExampleUseCaseParams;
import com.gmail.dan2011.gigi.audioLib.usecase.core.UseCase;
import com.gmail.dan2011.gigi.audioLib.usecase.response.VoidResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class DummyTestIT {

  @Autowired
  private ExampleService exampleService;

  @MockBean
  UseCase<ExampleUseCaseParams, VoidResponse> exampleUseCase;

  @DisplayName("Given a message When service is invoked Then all flow is executed OK.")
  @Test
  void emptyTestOK() {

    // Given
    final String message = "This is an OK message with an action!";

    // When
    given(exampleUseCase.execute(new ExampleUseCaseParams(message)))
        .willReturn(Either.right(VoidResponse.ok()));
    final String result = this.exampleService.execute(message);

    // Then
    assertEquals(message, result);
  }

  @DisplayName("Given an empty message When service is invoked Then all flow is executed And response is KO.")
  @Test
  void emptyTestNOK() {

    // Given
    final String message = "";

    // When
    given(exampleUseCase.execute(new ExampleUseCaseParams(message)))
        .willReturn(Either.left(Validation.empty()));
    final String result = this.exampleService.execute(message);

    // Then
    assertEquals("ERROR", result);
  }
}