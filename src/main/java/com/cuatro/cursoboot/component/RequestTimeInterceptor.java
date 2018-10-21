package com.cuatro.cursoboot.component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
// -----------------------------------------------------------------------------------
// Ejemplo de componente que intercepta todas las peticiones del controlador para calcular su tiempo
// Es necesario registrar en la clase de configuración WebMvcConfiguration esta clase
// -----------------------------------------------------------------------------------
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

  private static final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);

  // Este método se ejecuta justo antes de empezar una petición al controlador
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    request.setAttribute("startTime",System.currentTimeMillis());
    return true;
  }

  // Este método se ejecuta justo antes de terminar la petición al controlador
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    Long startTime = (Long) request.getAttribute("startTime");
    LOGGER.info("Request url " +request.getRequestURL() + " total time: " +  (System.currentTimeMillis()-startTime ) +"ms");
  }
}
