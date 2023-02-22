package com.gmail.dan2011.gigi.audioLib.infrastructure.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ExampleControllerTest {

  private ApplicationContextRunner runner;

  @BeforeEach
  void setUp() {
    this.runner = new ApplicationContextRunner()
        .withUserConfiguration(ExampleControllerTest.class);
  }

  @Test
  void testContextOk() {
    this.runner
        .run(context -> {
          assertThat(context).hasSingleBean(ExampleControllerTest.class);
        });
  }

  @Test
  void executeControllerWithoutErrors() {
    this.runner
        .run(context -> {
          final ExampleController notificationController = context.getBean(ExampleController.class);
          final String result = notificationController.execute("Message action");
          assertThat(result).isEqualTo("Message action");
        });
  }

  @Test
  void executeControllerWithErrors() {
    this.runner
        .run(context -> {
          final ExampleController notificationController = context.getBean(ExampleController.class);
          final String result = notificationController.execute("");
          assertThat(result).isEqualTo("ERROR");
        });
  }

}