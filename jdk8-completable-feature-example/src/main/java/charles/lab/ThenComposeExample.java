
package charles.lab;

import java.util.concurrent.CompletableFuture;

public class ThenComposeExample {

  public static void main(String[] args) {
    String original = "Message";
    CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(String::toUpperCase)
        .thenCompose(upper -> CompletableFuture.completedFuture(original).thenApply(String::toLowerCase)
                .thenApply(s -> upper + s));
    
    System.out.println(cf.join());
  }


}

