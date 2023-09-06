package ds_algo.backtracking;

/**
 * Author: kunitin
 * Created: 06/09/23
 * Info: A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1].
 * A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down.
 * <p>
 * Time complexity:
 * space complexity: O(n^2)
 **/

public class RatMazeProblem {
    public static void main(String[] args) {
        System.out.println("Maze:");
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        printMatrix(maze);
        System.out.println("Solution:");
        int[][] solnMatrix = ratMazeSoln(maze);
        printMatrix(solnMatrix);

        System.out.println("**********");

        int[][] maze1 = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 1, 0},
                {1, 1, 1, 1}
        };
        printMatrix(maze1);

        System.out.println("Solution:");
        int[][] solnMatrix1 = ratMazeSoln(maze1);
        printMatrix(solnMatrix1);

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] ratMazeSoln(int[][] maze) {
        int[][] soln = new int[maze.length][maze[0].length];
        int x = 0, y = 0;
        boolean solnExists = ratMazeUtil(maze, x, y, soln);
        System.out.println("solnExists: " + solnExists);
        return soln;
    }

    private static boolean ratMazeUtil(int[][] maze, int x, int y, int[][] soln) {

        if (x == maze.length - 1 && y == maze[0].length - 1 && soln[x][y] == 0) {
            soln[x][y] = 1;
            //System.out.println("soln found");
            return true;
        }
        if (canMove(maze, x, y)) {
            //if already traversed before
            if (soln[x][y] == 1) {
                return false;
            }
            soln[x][y] = 1;
            if (ratMazeUtil(maze, x, y + 1, soln)) {
                return true;
            }
            if (ratMazeUtil(maze, x + 1, y, soln)) {
                return true;
            }
            soln[x][y] = 0;
        }
        return false;
    }

    private static boolean canMove(int[][] maze, int x, int y) {
        //System.out.println("\nChecking for x=" + x + ", y=" + y);
        if (x >= maze.length || x < 0 || y >= maze[0].length || y < 0) {
            //System.out.println("Error in position");
            return false;
        }
        //System.out.println("can i move: " + (maze[x][y] == 1));
        return maze[x][y] == 1;
    }
}

/*

Maze:
 1 0 0 0
 1 1 0 1
 0 1 0 0
 1 1 1 1

Solution:
solnExists: true
 1 0 0 0
 1 1 0 0
 0 1 0 0
 0 1 1 1

**********
 1 0 0 0
 1 1 1 1
 0 0 1 0
 1 1 1 1

Solution:
solnExists: true
 1 0 0 0
 1 1 1 0
 0 0 1 0
 0 0 1 1
 */
