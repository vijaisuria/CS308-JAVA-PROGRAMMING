import java.util.Arrays;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class ColumnSort3568 {
    public static void main(String[] args) {
    System.out.println("Current Date: " + LocalDate.now());
    System.out.println("Current Time: " + LocalTime.now());
    System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        System.out.println("Enter elements of the first matrix:");
        readMatrix(scanner, matrix1);
         System.out.println("Enter elements of the second matrix:");
        readMatrix(scanner, matrix2);

        int[][] resultMatrix = addMatrices(matrix1, matrix2);

        System.out.println("Matrix after addition:");
        printMatrix(resultMatrix);

        sortMatrixByColumnSum(resultMatrix);

        System.out.println("Matrix after sorting by column sums:");
        printMatrix(resultMatrix);
    }
     public static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                 System.out.printf("Enter m[%d][%d]:",i,j);
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static void sortMatrixByColumnSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] columnSums = new int[cols];

        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
            }
            columnSums[j] = sum;
        }

        int[][] sortedMatrix = new int[rows][cols];
        Integer[] columnIndices = new Integer[cols];
        for (int i = 0; i < cols; i++) {
            columnIndices[i] = i;
        }

        Arrays.sort(columnIndices, (col1, col2) -> Integer.compare(columnSums[col1], columnSums[col2]));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sortedMatrix[i][j] = matrix[i][columnIndices[j]];
            }
        }

        
        for (int i = 0; i < rows; i++) {
            System.arraycopy(sortedMatrix[i], 0, matrix[i], 0, cols);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
