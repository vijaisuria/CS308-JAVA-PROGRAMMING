import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.time.LocalDate;
import java.time.LocalTime;

public class PrimeFind3568 {
    public static void main(String[] args) throws Exception {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");

        int totalNumbers = 1000000;
        int threadCount = 5;
        int rangeSize = totalNumbers / threadCount;

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        Future<Integer>[] results = new Future[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int startRange = i * rangeSize + 1;
            final int endRange = (i + 1) * rangeSize;
            results[i] = executorService.submit(new PrimeCounter(startRange, endRange));

            System.out.printf("Thread %d: Number of primes from %d to %d: %d", i+1, startRange, endRange, results[i].get());
            System.out.println();
        }

        int totalPrimes = 0;
        for (int i = 0; i < threadCount; i++) {
            totalPrimes += results[i].get();
        }

        executorService.shutdown();

        System.out.println("\nTotal prime numbers in the range 1 to 1,000,000: " + totalPrimes);
    }

    static class PrimeCounter implements Callable<Integer> {
        private final int start;
        private final int end;

        PrimeCounter(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int count = 0;
            for (int num = start; num <= end; num++) {
                if (isPrime(num)) {
                    count++;
                }
            }
            return count;
        }

        // Helper function to check if a number is prime
        private boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
