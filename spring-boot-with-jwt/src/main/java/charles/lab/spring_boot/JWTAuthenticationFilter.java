package charles.lab.spring_boot;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JWTAuthenticationFilter extends GenericFilterBean{

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) req;
    String token =  httpRequest.getHeader(TokenAuthenticationService.HEADER_STRING);
    
    Authentication auth =  TokenAuthenticationService.getAuthentication(token);
    
    SecurityContextHolder.getContext().setAuthentication(auth);
    filterChain.doFilter(req, res);
  }
  
}
