package charles.lab.spring_boot;

import java.util.Arrays;
import java.util.stream.Stream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {
  
  @RequestMapping("/test/cookie")
  public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
    //get session
    Object sessionBrowser = session.getAttribute("browser");
    if(sessionBrowser==null) {
      System.out.println("session don't exist, set session = " + browser);
      session.setAttribute("browser", browser);
    }else {
      System.out.println("session exist, browser = " + session.getAttribute("browser"));
    }
    
    Stream<Cookie> stream = Arrays.stream(request.getCookies());
    stream.forEach(c -> System.out.println(c.getName() + ":" + c.getValue()));
    
    return "index";
    
  }
}
