
package charles.lab;

import java.util.concurrent.CompletableFuture;

public class RunAfterBothExample {

  public static void main(String[] args) {
    String original = "Message";
    StringBuilder result = new StringBuilder();
    CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).runAfterBoth(
            CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
            () -> result.append("done"));
    System.out.println(result);
  }


}

