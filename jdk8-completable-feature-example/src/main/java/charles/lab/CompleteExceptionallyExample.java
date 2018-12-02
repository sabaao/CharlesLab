package charles.lab;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class CompleteExceptionallyExample {

  public static void main(String[] args) {
    
    CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
    CompletableFuture handler = cf.handle((s,th)->{
      return (th!=null)?"message up cancel":"";
    });
    
    cf.completeExceptionally(new RuntimeException("complete exception"));
    
    System.out.println("cf.isCompletedExceptionally():" + cf.isCompletedExceptionally());
    
    try {
      cf.join();
      
    }catch(CompletionException e) {
      System.out.println("exception message:" + e.getCause().getMessage());
    }
    
    System.out.println("handler.join():" + handler.join());
  }

}
