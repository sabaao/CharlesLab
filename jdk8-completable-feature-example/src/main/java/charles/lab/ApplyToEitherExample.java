
package charles.lab;

import java.util.concurrent.CompletableFuture;

public class ApplyToEitherExample {

  public static void main(String[] args) {
    String original = "Message";
    CompletableFuture cf1 =
        CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedUpperCase(s));
    CompletableFuture cf2 = cf1.applyToEither(
        CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
        s -> s + " from applyToEither");
    System.out.println("cf2.join():" + cf2.join());
    
  }

  private static String delayedUpperCase(String s) {
    return s.toUpperCase();
  }
  
  private static String delayedLowerCase(String s) {
    return s.toLowerCase();
  }

}

