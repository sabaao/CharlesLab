package charles.lab;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptExample {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    CompletableFuture.completedFuture("thenAccept message").thenAccept(s->sb.append(s));
    System.out.println(sb);
  }

}
