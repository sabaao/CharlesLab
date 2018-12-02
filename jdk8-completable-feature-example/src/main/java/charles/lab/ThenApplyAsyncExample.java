package charles.lab;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class ThenApplyAsyncExample {

  public static void main(String[] args) {
    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s->{
      System.out.println("is daemon:" + Thread.currentThread().isDaemon());
      try {
        randomSleep();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      return s.toUpperCase();
    });
    
    System.out.println("getnow:" + cf.getNow(null));
    System.out.println("join:" + cf.join());

  }
  
  
  private static void randomSleep() throws InterruptedException {
    Random random = new Random();
    Thread.sleep(random.nextInt(3000));
    
  }
}
