package charles.lab.spring_boot;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;

@Order(1)
@WebFilter(filterName="demoFilter1",urlPatterns="/*")
public class DemoFilter implements Filter {

  @Override
  public void destroy() {
    System.out.println("this is destory");
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain arg2)
      throws IOException, ServletException {
    System.out.println("TestFilter1");
    arg2.doFilter(req,res);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    System.out.println("this is init");
    
  }
  
}
