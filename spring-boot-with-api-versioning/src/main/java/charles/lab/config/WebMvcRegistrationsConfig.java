package charles.lab.config;

import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebMvcRegistrationsConfig extends WebMvcRegistrationsAdapter {

  @Override
  public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
    return new ApiVersioningRequestMappingHandlerMapping();
  }
  
}
