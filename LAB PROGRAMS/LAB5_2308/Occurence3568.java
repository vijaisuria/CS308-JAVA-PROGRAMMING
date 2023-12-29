import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Occurence3568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        int n = random.nextInt(10) + 1; 

        int[] A = new int[n];
        int[] B = new int[n];

        System.out.println("Randomly generated value of n: " + n);

        System.out.println("Random integers for array A:");
        for (int i = 0; i < n; i++) {
            A[i] = random.nextInt(100); 
            System.out.print(A[i] + " ");
        }
        System.out.println();

        System.out.println("Random integers for array B:");
        for (int i = 0; i < n; i++) {
            B[i] = random.nextInt(100);
            System.out.print(B[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            int count = countOccurrences(A, B[i]);
            System.out.println("Number of occurrences of " + B[i] + " in array A: " + count);
        }
    }

    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}