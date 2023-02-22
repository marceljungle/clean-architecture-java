package com.example.clean.architecture.infrastructure.bean.management;

import com.example.clean.architecture.usecase.core.UseCase;
import com.example.clean.architecture.usecase.audiolib.ExampleUseCase;
import com.example.clean.architecture.usecase.audiolib.params.ExampleUseCaseParams;
import com.example.clean.architecture.usecase.response.VoidResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializer {

  @Bean
  public UseCase<ExampleUseCaseParams, VoidResponse> sendEventMessage() {
    return new ExampleUseCase();
  }
}
