package coding.playground.patterns.twopointers;

import java.util.*;

// Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0. The solution
// must not contain duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are considered duplicate triplets).
// If no such triplets are found, return an empty array.
// Each triplet can be arranged in any order, and the output can be returned in any order.
public class TripletSum {
    public static void main(String[] args) {
        int[] nums = new int[]{0, -1, 2, -3, 1};
        // expected output: [[-3, 1, 2], [-1, 0, 1]]

        int[] nums2 = new int[]{-4, -4, -2, 0, 0, 1, 2, 3};
        // expected output: [[-4, 1, 3], [-2, 0, 2]]

        var result1 = tripletSumBruteForce(nums);
        System.out.println(result1);
        var result2 = tripletSumBruteForce(nums2);
        System.out.println(result2);
    }

    // Time complexity: O(n3) -> three nested loops, where n is the length of the input array
    // Space complexity: O(k) -> number of unique triplets stored in the set,
    private static List<List<Integer>> tripletSumBruteForce(int[] nums) {
        // Set to avoid duplicate triplets
        Set<List<Integer>> resultSet = new HashSet<>();

        // Brute force: check all triplets
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        // Sort the triplet before adding it to the set
                        Collections.sort(triplet);
                        resultSet.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
