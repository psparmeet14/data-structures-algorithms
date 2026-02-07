package coding.playground.patterns.hashmapsandsets;

import java.util.HashSet;
import java.util.Set;

// For each zero in an m x n matrix, set its entire row and column to zero in place.
public class ZeroStriping {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 0, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 0}
        };

        /*
            expected array
            {
                {1, 0, 3, 4, 0},
                {0, 0, 0, 0, 0},
                {11, 0, 13, 14, 0},
                {0, 0, 0, 0, 0}
            }
       */
        zeroStripingHashSet(matrix);
        // print a matrix
        for (int[] row : matrix) { // Outer loop for rows
            for (int element : row) { // Inner loop for columns
                System.out.print(element + " "); // Print element followed by a space
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // Time complexity: The time complexity is O(m*n) because we perform two passes over the
    // matrix and perform constant-time operations in each pass
    // Space complexity: The space complexity is O(m + n) due to the growth of the hash sets
    // used to track zero: one hash set scales with the number of rows, and the other scales with
    // the number of columns. In the worst case, every row and column has a zero.
    private static void zeroStripingHashSet(int[][] matrix) {
        Set<Integer> zeroRowsSet = new HashSet<>();
        Set<Integer> zeroColumnsSet = new HashSet<>();
        // Pass 1: Traverse through the matrix to identify the rows and columns
        // containing zeros and store their indexes in the appropriate hash sets
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    zeroRowsSet.add(r);
                    zeroColumnsSet.add(c);
                }
            }
        }
        // Pass 2: Set any cell in the matrix to zero if its row index is in
        // 'zeroRowsSet' or its column index is in 'zeroColumnSet'.
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (zeroRowsSet.contains(r) || zeroColumnsSet.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
