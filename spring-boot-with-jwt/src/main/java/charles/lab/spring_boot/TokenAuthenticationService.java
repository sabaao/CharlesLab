package charles.lab.spring_boot;

import static java.util.Collections.emptyList;
import java.util.Date;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
  static final long EXPIRATIONTIME = 864_000_000; // 10 days
  static final String SECRET = "ThisIsASecret";
  static final String TOKEN_PREFIX = "Bearer";
  static final String HEADER_STRING = "Authorization";

  public static String addAuthentication(String username) {
    String jwt = Jwts.builder().setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
        .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    return TOKEN_PREFIX + " " + jwt;
  }

  public static Authentication getAuthentication(String token) {
    if (token != null) {
      String user = Jwts.parser().setSigningKey(SECRET)
          .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();
      
      if(user!=null) {
        return new UsernamePasswordAuthenticationToken(user, null,emptyList());
      }else {
        return null;
      }
    }
    
    return null;
  }
}
