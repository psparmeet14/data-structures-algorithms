package coding.playground.patterns.hashmapsandsets;

import java.util.HashSet;
import java.util.Set;

/*
    Given a partially completed 9*9 Sudoku board, determine if the current state of the board adheres to the rules
    of the game:
    - Each row and column must contain unique numbers between 1 and 9, or be empty (represented as 0)
    - Each of the nine 3*3 subgrids that compose the grid must contain unique numbers between 1 and 9, or be empty.

    Note: You are asked to determine whether the current state of the board is valid given these rules, not
    whether the board is solvable.
 */
public class VerifySudokuBoard {

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println(isValidSudoku(board));
    }

    // Time complexity: O(n^2), where n is the size of the board.
    // Space complexity: O(n^2), because of row, column, and subgrid sets.
    // for a fixed 9*9 board, this is effectively O(1)
    // We iterate through each cell once, so the time complexity is O(n²).
    // We maintain hash sets for rows, columns, and subgrids, which together take O(n²) space.
    // Since Sudoku is always 9×9, both effectively become O(1) in practice.
    public static boolean isValidSudoku(int[][] board) {
        Set<Integer>[] rowSets = new HashSet[9];
        Set<Integer>[] columnSets = new HashSet[9];
        Set<Integer>[][] subgridSets = new HashSet[3][3];

        // initialize sets
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            columnSets[i] = new HashSet<>();
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                subgridSets[r][c] = new HashSet<>();
            }
        }

        // one-pass traversal of the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int num = board[r][c];

                if (num == 0) {
                    continue;
                }

                // check row
                if (rowSets[r].contains(num)) {
                    return false;
                }
                // check column
                if (columnSets[c].contains(num)) {
                    return false;
                }
                // check subgrid
                int subgridRow = r / 3;
                int subgridCol = c / 3;
                if (subgridSets[subgridRow][subgridCol].contains(num)) {
                    return false;
                }
                // mark number as seen
                rowSets[r].add(num);
                columnSets[c].add(num);
                subgridSets[subgridRow][subgridCol].add(num);
            }
        }

        return true;
    }
}
