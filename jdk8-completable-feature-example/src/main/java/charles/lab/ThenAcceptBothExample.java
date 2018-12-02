
package charles.lab;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptBothExample {

  public static void main(String[] args) {
    String original = "Message";
    StringBuilder result = new StringBuilder();
    CompletableFuture cf =
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
            CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
            (s1, s2) -> result.append(s1 + s2));

    System.out.println(result);
  }


}

