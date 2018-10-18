package charles.lab.config;

import java.lang.reflect.Method;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import charles.lab.annotation.ApiVersion;

public class ApiVersioningRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

  private RequestCondition<ApiVersionCondition> createCondition(ApiVersion apiVersion) {
    return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
  }

  @Override
  protected RequestCondition<ApiVersionCondition> getCustomTypeCondition(Class<?> handlerType) {
    ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
    return createCondition(apiVersion);
  }
  
  @Override
  protected RequestCondition<ApiVersionCondition> getCustomMethodCondition(Method method){
    ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
    return createCondition(apiVersion);
  }
}
