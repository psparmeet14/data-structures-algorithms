package coding.archived.arrays.easy;

/**
 * EASY

 You're given a 2D array of integers matrix. Write a function
 that returns the transpose of the matrix.

 The transpose of a matrix is a flipped version of the original matrix across
 its main diagonal (which runs from top-left to bottom-right); it switches
 the row and column indices of the original matrix.

 You can assume the input matrix always has at least 1 value; however its
 width and height are not necessarily the same.

Sample Input:
 matrix = [
 [1, 2],
 [3, 4],
 [5, 6]
 ]

 Sample Output:
 [
 [1, 3, 5],
 [2, 4, 6]
 ]

 */
public class TransposeMatrix {

    // O(w * h) time | O(w * h) space - where w is the width of the matrix and h is the height
    public int[][] transposeMatrix(int[][] matrix) {
    /*
      matrix = [  // 3 * 2
        [1, 2],
        [3, 4],
        [5, 6]
      ]

      Output = [  // 2 * 3
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

        return transposedMatrix;
    }

    // O(w * h) time | O(w * h) space - where w is the width of the matrix and h is the height
    public int[][] transposeMatrix2(int[][] matrix) {
    /*
      matrix = [  // 3 * 2
        [1, 2],
        [3, 4],
        [5, 6]
      ]

      Output = [  // 2 * 3
        [1, 3, 5],
        [2, 4, 6]
      ]
    */
        int rows = matrix.length;
        int[][] transpose = new int[matrix[0].length][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }
}
