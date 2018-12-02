
package charles.lab;

import java.util.concurrent.CompletableFuture;

public class ThenCombineAsyncExample {

  public static void main(String[] args) {
    String original = "Message";
    StringBuilder result = new StringBuilder();
    CompletableFuture cf =
        CompletableFuture.completedFuture(original).thenApplyAsync(String::toUpperCase).thenCombine(
            CompletableFuture.completedFuture(original).thenApplyAsync(String::toLowerCase),
            (s1, s2) -> s1 + s2);
    
    System.out.println(cf.join());
    
  }


}

