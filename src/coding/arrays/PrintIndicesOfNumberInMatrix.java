package coding.arrays;

import java.util.Scanner;

public class PrintIndicesOfNumberInMatrix {
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

        System.out.println("Enter number to find indices for:");
        int number = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == number) {
                    System.out.println("Number found at location: (" + i + ", " + j + ")");
                }
            }
        }
    }
}
