package com.gmail.dan2011.gigi.audioLib.infrastructure.bean.management;

import com.gmail.dan2011.gigi.audioLib.usecase.audiolib.ExampleUseCase;
import com.gmail.dan2011.gigi.audioLib.usecase.audiolib.params.ExampleUseCaseParams;
import com.gmail.dan2011.gigi.audioLib.usecase.core.UseCase;
import com.gmail.dan2011.gigi.audioLib.usecase.response.VoidResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializer {

  @Bean
  public UseCase<ExampleUseCaseParams, VoidResponse> sendEventMessage() {
    return new ExampleUseCase();
  }
}
