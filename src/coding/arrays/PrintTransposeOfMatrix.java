package coding.arrays;

import java.util.Scanner;

public class PrintTransposeOfMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
          /*
      matrix = [  // 3 * 2
        [1, 2],
        [3, 4],
        [5, 6]
      ]

      Output (Transposed matrix) = [  // 2 * 3
        [1, 3, 5],
        [2, 4, 6]
      ]
    */
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                transposedMatrix[col][row] = matrix[row][col];
            }
        }

        System.out.println("Printing the matrix: ");
        rows = transposedMatrix.length;
        columns = transposedMatrix[0].length;
        // print the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
