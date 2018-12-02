
package charles.lab;

import java.util.concurrent.CompletableFuture;

public class AcceptEitherExample {

  public static void main(String[] args) {
    String original = "Message";
    StringBuilder sb = new StringBuilder();
    CompletableFuture cf = CompletableFuture.completedFuture(original)
        .thenApplyAsync(s -> delayedUpperCase(s)).acceptEither(
            CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
            s -> sb.append(s).append("acceptEither"));
    cf.join();
    
    System.out.println(sb);

  }

  private static String delayedUpperCase(String s) {
    return s.toUpperCase();
  }

  private static String delayedLowerCase(String s) {
    return s.toLowerCase();
  }

}

