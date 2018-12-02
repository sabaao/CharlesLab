package charles.lab;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
  private static Future<String> calculateAsync;

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    App app = new App();
    calculateAsync = app.calculateAsync();
    System.out.println("result:" + calculateAsync.get());
  }
  
  public Future<String> calculateAsync() throws InterruptedException{
    CompletableFuture<String> completableFuture = new CompletableFuture<String>();
    Executors.newCachedThreadPool().submit(()->{
      Thread.sleep(5000);
      completableFuture.complete("Hello");
      return null;
    });
    
    return completableFuture;
  }
}
