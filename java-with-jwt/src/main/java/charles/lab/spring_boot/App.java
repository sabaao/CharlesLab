package charles.lab.spring_boot;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class App {
  public static String secretKey = "secretKey";
  
  /**
   * create jwt token
   * @return
   * @throws IllegalArgumentException
   * @throws UnsupportedEncodingException
   */
  public static String createJwt() throws IllegalArgumentException, UnsupportedEncodingException {
    Algorithm al = Algorithm.HMAC256(secretKey);
    String token = JWT.create()
        .withIssuer("designer")
        .withSubject("user")
        .withClaim("userid", 1234)
        .withExpiresAt(new Date(System.currentTimeMillis()+ 360000))
        .sign(al);
    return token;
  }
  
  /**
   * decode jwt
   * @param token
   * @return
   * @throws IllegalArgumentException
   * @throws UnsupportedEncodingException
   */
  public static int verifyJwt(String token) throws IllegalArgumentException, UnsupportedEncodingException {
    Algorithm al = Algorithm.HMAC256(secretKey);
    JWTVerifier verifier = JWT.require(al).build();
    DecodedJWT jwt = verifier.verify(token);
    return jwt.getClaim("userid").asInt();
  }

  public static void main(String[] args) throws IllegalArgumentException, UnsupportedEncodingException {
    String token = App.createJwt();
    System.out.println("token:" + token);
    System.out.println("userid:" + verifyJwt(token));
    
  }
}
