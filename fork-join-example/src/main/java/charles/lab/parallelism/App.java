package charles.lab.parallelism;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;


public class App {
  static final int SIZE = 10_000_000;

  static int[] array = randomArray();

  static int[] randomArray() {
    int[] array = new int[SIZE];
    Random random = new Random();
    for (int i = 0; i < SIZE; i++) {
      array[i] = random.nextInt(100);
    }
    return array;
  }

  public static void main(String[] args) {
    int threshold = 2;
    int parallelism = Runtime.getRuntime().availableProcessors();

    long startTime = System.currentTimeMillis();

    ArrayCounter mainTask = new ArrayCounter(array, 0, SIZE, threshold);
    ForkJoinPool pool = new ForkJoinPool(parallelism);
    Integer evenNumberCount = pool.invoke(mainTask);

    long endTime = System.currentTimeMillis();

    System.out.println("Number of even numbers: " + evenNumberCount);

    long time = (endTime - startTime);
    System.out.println("Execution time: " + time + " ms");
  }
}
