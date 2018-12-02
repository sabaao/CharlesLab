package charles.lab;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThenApplyAsyncWithExecutorExample {
  
  public static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
    int count = 1;
    @Override
    public Thread newThread(Runnable r) {
      
      return new Thread(r,"custom-executor-" + count++);
    }
  });
  
  public static void main(String[] args) {
    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s->{
      System.out.println("thread name:" + Thread.currentThread().getName());
      System.out.println("is daemon:" + Thread.currentThread().isDaemon());
      try {
        randomSleep();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      return s.toUpperCase();
    },executor);
    
    System.out.println("getnow:" + cf.getNow(null));
    System.out.println("join:" + cf.join());

  }
  
  
  private static void randomSleep() throws InterruptedException {
    Random random = new Random();
    Thread.sleep(random.nextInt(3000));
    
  }
}
