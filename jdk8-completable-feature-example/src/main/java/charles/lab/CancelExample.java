package charles.lab;

import java.util.concurrent.CompletableFuture;

public class CancelExample {

  public static void main(String[] args) {
    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
    CompletableFuture cf2 = cf.exceptionally(thrown->"canceled exception");
    
    System.out.println("cf.cancel(true):" + cf.cancel(true));
    System.out.println("cf.isCompletedExceptionally():" + cf.isCompletedExceptionally());
    System.out.println("cf2.join():" + cf2.join());
    
  }

}
