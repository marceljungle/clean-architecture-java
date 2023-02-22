package com.example.clean.architecture.infrastructure.controller;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.example.clean.architecture.infrastructure.controller.config.ExampleControllerConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

public class ExampleControllerTest {

  private ApplicationContextRunner runner;

  @BeforeEach
  void setUp() {
    this.runner = new ApplicationContextRunner()
        .withUserConfiguration(ExampleControllerConfig.class);
  }

  @Test
  void testContextOk() {
    this.runner
        .run(context -> {
          assertThat(context).hasSingleBean(ExampleControllerConfig.class);
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