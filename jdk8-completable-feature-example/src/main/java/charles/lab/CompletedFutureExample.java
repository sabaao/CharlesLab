package charles.lab;
import java.util.concurrent.CompletableFuture;

public class CompletedFutureExample {
  public static void main(String[] args) {
    CompletableFuture cf = CompletableFuture.completedFuture("message");
    System.out.println("is done:" + cf.isDone());
    System.out.println("result:" + cf.getNow(null));
  }
}
