package ds_algo.recursion_backtracking;

/**
 * Author: kunitin
 * Created: 20/09/23
 * Info: Solve given sudoku of 9 x9 .
 * Rules:
 * 1. Each row should have numbers 1 to 9
 * 2. Each column should have numbers 1 to 9
 * 3. Each 9 sub-matrix of size 3 x3 should have numbers 1 to 9
 * <p>
 * Approach: Start filling filling values from 1 to 9 in each of the empty boxes. Recursively proceed with the filled sudoku box.
 * <p>
 * Time Complexity: O(9 ^ m).  For every m unfilled box, there are 9 possible options.  Not sure. Re-check later
 * Space Complexity: O(1)
 **/

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku = {{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        printMatrix(sudoku);

        solveSudoku(sudoku);
        // printMatrix(sudoku);


    }

    private static void solveSudoku(int[][] sudoku) {

        //base case
        if (isAllFilled(sudoku)) {
            printMatrix(sudoku);
            return;
        }

        for (int r = 0; r < sudoku.length; r++) {
            for (int c = 0; c < sudoku[0].length; c++) {

                //found a box to be filled
                if (sudoku[r][c] == 0) {
                    //System.out.println("to fill row=" + r + " column=" + c);
                    //try to fill all possible number from 1 to 9
                    for (int n = 1; n <= 9; n++) {
                        if (canFill(n, r, c, sudoku)) {
                            //System.out.println("sudoku[" + r + "][" + c + "] =" + n);
                            sudoku[r][c] = n;
                            solveSudoku(sudoku);

                            //revert if it is not the last box to be filled. Return if all boxes are filled
                            if (!isAllFilled(sudoku)) {
                                sudoku[r][c] = 0;
                                //System.out.println("-> sudoku[" + r + "][" + c + "] = 0");
                            } else {
                                return;
                            }
                        }
                    }
                    //return if still could not find a number for this position
                    if (sudoku[r][c] == 0) {
                        return;
                    }

                }

            }
        }
        return;
    }

    private static boolean canFill(int num, int r, int c, int[][] sudoku) {
        for (int count = 0; count < 9; count++) {
            //if row or column already has that number
            if (sudoku[count][c] == num || sudoku[r][count] == num) {
                return false;
            }
            //if sub-matrix already has that number
            if (sudoku[3 * (r / 3) + (count / 3)][3 * (c / 3) + (count % 3)] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAllFilled(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

/*
O/P:
5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9

5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
 */