
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Multithread3568 {
    public static void main(String[] args) {
        int loopSize = 1000000; // The size of the loop

        // Traditional (Single-threaded) Approach
        long singleThreadStartTime = System.currentTimeMillis();
        for (int i = 0; i < loopSize; i++) {
            // Simulate some time-consuming work
            performTask();
        }
        long singleThreadEndTime = System.currentTimeMillis();
        long singleThreadExecutionTime = singleThreadEndTime - singleThreadStartTime;
        System.out.println("Single-threaded Execution Time: " + singleThreadExecutionTime + "ms");

        // Multi-threading Approach
        int numThreads = 4; // Number of threads to use
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        long multiThreadStartTime = System.currentTimeMillis();

        for (int i = 0; i < loopSize; i++) {
            final int taskNumber = i;
            executor.execute(() -> {
                // Simulate some time-consuming work
                performTask();
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long multiThreadEndTime = System.currentTimeMillis();
        long multiThreadExecutionTime = multiThreadEndTime - multiThreadStartTime;
        System.out.println("Multi-threaded Execution Time: " + multiThreadExecutionTime + "ms");
    }

    private static void performTask() {
        // Simulate some time-consuming work
        for (int i = 0; i < 10000; i++) {
            Math.sqrt(i);
        }
    }
}

