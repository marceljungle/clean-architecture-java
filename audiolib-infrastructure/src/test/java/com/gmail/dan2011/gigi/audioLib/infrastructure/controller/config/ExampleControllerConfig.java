package com.gmail.dan2011.gigi.audioLib.infrastructure.controller.config;

import com.gmail.dan2011.gigi.audioLib.infrastructure.bean.management.BeanInitializer;
import com.gmail.dan2011.gigi.audioLib.infrastructure.controller.ExampleController;
import com.gmail.dan2011.gigi.audioLib.usecase.audiolib.params.ExampleUseCaseParams;
import com.gmail.dan2011.gigi.audioLib.usecase.core.UseCase;
import com.gmail.dan2011.gigi.audioLib.usecase.response.VoidResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleControllerConfig extends BeanInitializer {

  @Bean
  public ExampleController notificationController(final UseCase<ExampleUseCaseParams, VoidResponse> exampleUseCase) {
    return new ExampleController(exampleUseCase);
  }

}