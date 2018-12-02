package charles.lab;

import java.util.concurrent.CompletableFuture;

public class ThenApplyExample {

  public static void main(String[] args) {
    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s->{
      System.out.println("is daemon:" + Thread.currentThread().isDaemon());
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return s.toUpperCase();
    });
    
    System.out.println("result:" + cf.getNow(null));
    
  }

}
