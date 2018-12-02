package charles.lab;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class RunAsyncExample {

  public static void main(String[] args) throws InterruptedException {
    CompletableFuture cf = CompletableFuture.runAsync(()->{
      System.out.println("isDaemon:" + Thread.currentThread().isDaemon());
      try {
        randomSleep();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    
    System.out.println("is done:" + cf.isDone());
    randomSleep();
    System.out.println("is done:" + cf.isDone());
  }

  private static void randomSleep() throws InterruptedException {
    Random random = new Random();
    Thread.sleep(random.nextInt(3000));
    
  }

}
