package charles.lab.recursivetask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class App {
  static final int SIZE = 10_000_000;
  static int[] array = randomArray();

  public static void main(String[] args) {
    ArrayCounter mainTask = new ArrayCounter(array, 0, SIZE);
    ForkJoinPool pool = new ForkJoinPool();
    Integer evenNumberCount = pool.invoke(mainTask);
    System.out.println("number of even numbers:" + evenNumberCount);
  }

  private static int[] randomArray() {
    int[] array = new int[SIZE];
    Random random = new Random();
    IntStream.range(0, SIZE - 1).forEach(i -> {
      array[i] = random.nextInt(100);
    });
    return array;
  }
}
