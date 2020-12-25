package ds.matrix;

/**
 * Author: nitinkumar
 * Created Date: 19/12/20
 * Info: Rotate a square matrix by 90 degree in anticlockwise
 **/

public class SquareMatrixRotateAnticlockwise {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println("Original Matrix : ");
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("Matrix after rotation: ");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length / 2; i++) { //i is the ring number

            //stored top row of the ring.
            int[] temp = new int[matrix.length - (2 * i)];
            for (int j = 0 + i; j < matrix[0].length - i; j++) {
                temp[j - i] = matrix[i][j];
            }

            //move right side of ring to top
            for (int j = 0 + i; j < matrix[0].length - i; j++) {
                matrix[i][j] = matrix[j][matrix.length - 1 - i];
                // System.out.println("Assigning "+matrix[j][matrix.length - 1 - i]+" to position ["+i+"]["+j+"]");
            }
            //move bottom to right
            for (int j = 0 + i; j < matrix[0].length - i; j++) {
                matrix[j][matrix.length - 1 - i] = matrix[matrix[0].length - 1 - i][matrix[0].length - 1 - j];
                //System.out.println("Assigning "+matrix[matrix[0].length - 1 - i][matrix[0].length - 1 - j]+" to position ["+j+"]["+(matrix.length - 1 - i)+"]");
            }
            //move left to bottom
            for (int j = 0 + i; j < matrix[0].length - i; j++) {
                matrix[matrix[0].length - 1 - i][matrix[0].length - 1 - j] = matrix[matrix[0].length - 1 - j][i];
                // System.out.println("Assigning "+matrix[matrix[0].length -1- j][i]+" to position ["+(matrix[0].length - 1 - i)+"]["+(matrix[0].length - 1 - j)+"]");

            }
            //move temp (top) to left
            for (int j = 0 + i; j < matrix[0].length - i; j++) {
                matrix[matrix[0].length - 1 - j][i] = temp[j - i];
                // System.out.println("Assigning "+temp[j-i]+" to position ["+(matrix[0].length -1- j)+"]["+i+"]");
            }
        }
    }
}
/*
O/P
Original Matrix :
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Matrix after rotation:
4 8 12 16
3 7 11 15
2 6 10 14
1 5 9 13
 */