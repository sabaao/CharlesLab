package charles.lab.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

  private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");
  
  private int apiVersion;
  
  public ApiVersionCondition(int apiVersion) {
    this.apiVersion = apiVersion;
  }
  
  public int getApiVersion() {
    return apiVersion;
}
  
  @Override
  public ApiVersionCondition combine(ApiVersionCondition other) {
    return new ApiVersionCondition(other.getApiVersion());
  }

  @Override
  public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
    Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getRequestURI());
    if(m.find()) {
      Integer version = Integer.valueOf(m.group(1));
      if(version >= this.apiVersion) {
        return this;
      }
    }
    return null;
  }

  @Override
  public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
    return other.getApiVersion() - this.apiVersion;
  }

}
