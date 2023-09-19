package ds_algo.recursion_backtracking;

/**
 * Author: kunitin
 * Created: 19/09/23
 * Info: Place n queens in a board with n rows and n columns such that they do not attack each other
 * <p>
 * Approach: Start placing one queen in each row if possible and recursively solve this.
 * Time Complexity: O( n^2 + n)
 * Space Complexity: O(n^2)
 *
 *
 **/

public class PlacingNQueenInBoard {
    public static void main(String[] args) {
        int n = 5;
        int[][] board = new int[n][n];
        //printMatrix(board);
        System.out.println("Printing queen positions for board of size " + n);
        printQueenPositions(0, board);
    }

    private static void printQueenPositions(int row, int[][] board) {
        //found placement of queens
        if (row >= board.length) {
            printMatrix(board);
            return;
        }
        Position[] allPossiblePositions = findPositionsOfQueenInARow(row, board);
        for (Position position : allPossiblePositions) {
            if (position != null) {
                board[position.row][position.col] = 1;
                printQueenPositions(row + 1, board);
                board[position.row][position.col] = 0;
            }
        }
    }

    private static Position[] findPositionsOfQueenInARow(int r, int[][] board) {
        Position[] placement = new Position[board.length];
        int placementTracker = 0;

        for (int c = 0; c < board.length; c++) {
            //checking for possible placement in row r and column c

            //check in top left diagonal
            int tmpRow = r, tmpCol = c;
            boolean checkOne = true;
            while (tmpRow >= 0 && tmpCol >= 0) {
                if (board[tmpRow][tmpCol] == 1) {
                    checkOne = false;
                    break;
                }
                tmpRow--;
                tmpCol--;
            }

            //check in top right diagonal
            tmpRow = r;
            tmpCol = c;
            boolean checkTwo = true;
            while (tmpRow >= 0 && tmpCol < board.length) {
                if (board[tmpRow][tmpCol] == 1) {
                    checkTwo = false;
                    break;
                }
                tmpRow--;
                tmpCol++;
            }

            //check in vertical
            tmpRow = r;
            tmpCol = c;
            boolean checkThree = true;
            while (tmpRow >= 0) {
                if (board[tmpRow][tmpCol] == 1) {
                    checkThree = false;
                    break;
                }
                tmpRow--;
            }
            if (checkOne && checkTwo & checkThree) {
                placement[placementTracker++] = new Position(r, c);
            }

        }
        return placement;
    }

    private static void printMatrix(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    static class Position {
        int row;
        int col;

        public Position(int r, int c) {
            row = r;
            col = c;
        }
    }

}
/*
Output:
Printing queen positions for board of size 5
1 0 0 0 0
0 0 1 0 0
0 0 0 0 1
0 1 0 0 0
0 0 0 1 0
----------
1 0 0 0 0
0 0 0 1 0
0 1 0 0 0
0 0 0 0 1
0 0 1 0 0
----------
0 1 0 0 0
0 0 0 1 0
1 0 0 0 0
0 0 1 0 0
0 0 0 0 1
----------
0 1 0 0 0
0 0 0 0 1
0 0 1 0 0
1 0 0 0 0
0 0 0 1 0
----------
0 0 1 0 0
1 0 0 0 0
0 0 0 1 0
0 1 0 0 0
0 0 0 0 1
----------
0 0 1 0 0
0 0 0 0 1
0 1 0 0 0
0 0 0 1 0
1 0 0 0 0
----------
0 0 0 1 0
1 0 0 0 0
0 0 1 0 0
0 0 0 0 1
0 1 0 0 0
----------
0 0 0 1 0
0 1 0 0 0
0 0 0 0 1
0 0 1 0 0
1 0 0 0 0
----------
0 0 0 0 1
0 1 0 0 0
0 0 0 1 0
1 0 0 0 0
0 0 1 0 0
----------
0 0 0 0 1
0 0 1 0 0
1 0 0 0 0
0 0 0 1 0
0 1 0 0 0
----------

 */
