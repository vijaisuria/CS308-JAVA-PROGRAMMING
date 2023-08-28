import java.util.Arrays;
import java.util.Scanner;

public class Sum3568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] array1 = readArray(scanner, rows, columns, "Array 1");
        int[][] array2 = readArray(scanner, rows, columns, "Array 2");


        int[][] sumArrays = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sumArrays[i][j] = array1[i][j] + array2[i][j];  
            }
        }

        System.out.println("Sum array:");
        print2DArray(sumArrays);

        int[] colSum = getColumnSums(sumArrays);

        Arrays.sort(sumArrays, (a, b) -> Integer.compare(b[0], a[0]));

        System.out.println("Sorted sum array:");
        int[][] sortedSumArray = new int[2][columns];
        for (int i = 0; i < columns; i++) {
            int colIndex = sumArrays[i][1];
            sortedSumArray[i] = sumArrays[i];
            sortedSumArray[i][1] = colIndex;
        }
        print2DArray(sortedSumArray);
    }

    public static int[][] readArray(Scanner scanner, int rows, int columns, String arrayName) {
        int[][] array = new int[rows][columns];
        System.out.println("Enter values for " + arrayName + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }

    public static int[] getColumnSums(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        int[] columnSums = new int[columns];
        for (int j = 0; j < columns; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += array[i][j];
            }
            columnSums[j] = sum;
        }
        return columnSums;
    }

    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
