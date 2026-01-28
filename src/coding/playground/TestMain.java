package coding.playground;

import java.util.HashSet;
import java.util.Set;

public class TestMain {

    public static void main(String[] args) {
        printAllUniqueIndexPairs();
        printAllAdjacentIndexPairs();
        printAllOrderedIndexPairs();
        printAllOrderedIndexPairsIncludingSameIndices();
        printAllUniqueValuePairsAllowingRepeatsInInput();
    }

    // Print all unique value pairs (a, b) from the array allowing repeats in input.
    // It prints all unique pairs of values from the array, even if the input array contains duplicates.
    // Time Complexity: O(n^2), where n is the length of the array.
    // Space Complexity: O(m), where m is the number of unique pairs found.
    private static void printAllUniqueValuePairsAllowingRepeatsInInput() {
        int[] nums = new int[]{1, 2, 2, 3, 3, 3};
        Set<String> seenPairs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];

                // Canonical form to avoid duplicates like (2,3) and (3,2)
                int lo = Math.min(a, b);
                int hi = Math.max(a, b);
                String pairKey = lo + "," + hi;

                if (seenPairs.add(pairKey)) {
                    System.out.println("Unique Value Pair Allowing Repeats: (" + lo + ", " + hi + ")");
                }

            }
        }
    }

    // Print all ordered index pairs (i, j) including where i == j.
    // It prints all possible pairs of elements in the array including where both indices are the same
    // Time Complexity: O(n^2), where n is the length of the array.
    // Space Complexity: O(1)
    private static void printAllOrderedIndexPairsIncludingSameIndices() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        for (int num : nums) {
            for (int i : nums) {
                System.out.println("Ordered Pair Including Same Indices: (" + num + ", " + i + ")");
            }
        }
    }

    // Print all ordered index pairs (i, j) where i != j.
    // It prints all possible pairs of elements in the array except where both indices are the same
    // Time Complexity: O(n^2), where n is the length of the array.
    // Space Complexity: O(1)
    private static void printAllOrderedIndexPairs() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue; // Skip pairs where indices are the same
                }
                System.out.println("Ordered Pair: (" + nums[i] + ", " + nums[j] + ")");
            }
        }
    }

    // Print all adjacent index pairs (i, i+1).
    // It prints pairs of elements that are next to each other in the array.
    // Time Complexity: O(n), where n is the length of the array.
    // Space Complexity: O(1)
    private static void printAllAdjacentIndexPairs() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                System.out.println("Adjacent Pair: (" + nums[i] + ", " + nums[i + 1] + ")");
            }
        }
    }

    // Print all unique index pairs (i, j) such that i < j.
    // It prints all 2-combinations of the array elements.
    // No duplicates like (1,2) and (2,1), and it never prints (x, x).
    // Time Complexity: O(n^2), where n is the length of the array.
    // Space Complexity: O(1)
    private static void printAllUniqueIndexPairs() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("Pair: (" + nums[i] + ", " + nums[j] + ")");
            }
        }
    }
}
