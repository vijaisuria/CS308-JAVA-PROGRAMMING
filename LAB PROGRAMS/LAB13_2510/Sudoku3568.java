import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Sudoku3568
{
    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num)
    {
        // Row has the unique (row-clash)
        for (int d = 0; d < board.length; d++)
        {

            // Check if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        // Column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++)
        {

            // Check if the number
            // we are trying to
            // place is already present in
            // that column, return false;
            if (board[r][col] == num)
            {
                return false;
            }
        }

        // Corresponding square has
        // unique number (box-clash)
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }
    public static boolean solvePuzzle(int[][]board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;
                    isEmpty = false; // there are missing values in the board
                    break;
                }
            }
            if (!isEmpty)
            {
                break;
            }
        }

        // No empty space left
        if (isEmpty)
        {
            return true;
        }

        // Else for each-row backtrack
        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solvePuzzle(board, n))
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    public static void printBoard(int[][]board, int n)
    {
        for(int r=0; r<n; r++)
        {
            for(int c = 0; c<n; c++)
            {
                System.out.print(board[r][c]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        int [][] board;
        board = new int[][]{
                {2, 1, 0, 0},
                {3, 0, 0, 0},
                {0, 0, 3, 4},
                {0, 0, 2, 1}
        };
        int len = board.length;
        solvePuzzle(board, len);
        printBoard(board, len);
    }
}