package com.example.clean.architecture.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.clean.architecture.Application;
import com.example.clean.architecture.domain.services.ExampleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
class DummyTestITCase {

  @Autowired
  private ExampleService exampleService;

  @DisplayName("Given a message When service is invoked Then all flow is executed OK.")
  @Test
  void emptyTestOK() {

    // Given
    final String message = "This is an OK message with an action!";

    // When
    final String result = this.exampleService.execute(message);

    // Then
    assertEquals(message, result);
  }

  @DisplayName("Given an empty message When service is invoked "
      + "Then all flow is executed And response is KO.")
  @Test
  void emptyTestNOK() {

    // Given
    final String message = "";

    // When
    final String result = this.exampleService.execute(message);

    // Then
    assertEquals("ERROR", result);
  }
}