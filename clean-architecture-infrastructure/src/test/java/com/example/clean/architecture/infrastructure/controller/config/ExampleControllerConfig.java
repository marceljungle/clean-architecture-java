package com.example.clean.architecture.infrastructure.controller.config;

import com.example.clean.architecture.infrastructure.bean.management.BeanInitializer;
import com.example.clean.architecture.infrastructure.controller.ExampleController;
import com.example.clean.architecture.usecase.audiolib.params.ExampleUseCaseParams;
import com.example.clean.architecture.usecase.core.UseCase;
import com.example.clean.architecture.usecase.response.VoidResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleControllerConfig extends BeanInitializer {

  @Bean
  public ExampleController notificationController(
      final UseCase<ExampleUseCaseParams, VoidResponse> exampleUseCase) {
    return new ExampleController(exampleUseCase);
  }

}