package com.cuatro.cursoboot;

import com.cuatro.cursoboot.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
// Clase de configuración para que llame a nuestro interceptor
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

  @Autowired
  RequestTimeInterceptor requestTimeInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor( requestTimeInterceptor);
  }
}
