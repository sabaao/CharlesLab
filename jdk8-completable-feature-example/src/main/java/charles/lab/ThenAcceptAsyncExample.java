package charles.lab;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptAsyncExample {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    CompletableFuture cf = CompletableFuture.completedFuture("thenAcceptAsync message")
        .thenAcceptAsync(s -> sb.append(s));
    
    cf.join();
    System.out.println("result is " + sb);
  }

}
