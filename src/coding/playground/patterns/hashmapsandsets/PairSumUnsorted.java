package coding.playground.patterns.hashmapsandsets;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// Given an array of integers, return the indexes of any two numbers that add up to a target.
// The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.
// Constraints: the same index cannot be used twice in the result.
public class PairSumUnsorted {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 3, 4, 2};
        int target = 3;
        // Output: [0, 2]
        // Explanation: nums[0] + nums[2] = -1 + 4 = 3
        int[] result = pairSumUnsortedBruteForce(nums, target);
        System.out.println("Result brute force: [" + result[0] + ", " + result[1] + "]");

        int[] result2 = pairSumUnsortedSlightOptimization1(nums, target);
        System.out.println("Result pairSumUnsortedSlightOptimization1: [" + result2[0] + ", " + result2[1] + "]");

        int[] nums2 = new int[]{-1, 3, 4, 2};
        int target2 = 3;
        int[] result3 = pairSumUnsortedSlightOptimization2(nums2, target2);
        System.out.println("Result pairSumUnsortedSlightOptimization2: [" + result3[0] + ", " + result3[1] + "]");

        int[] result4 = pairSumSortedOptimized1(nums2, target2);
        System.out.println("Result optimized: [" + result4[0] + ", " + result4[1] + "]");

        int[] result5 = pairSumSortedOptimized2(nums2, target2);
        System.out.println("Result optimized: [" + result5[0] + ", " + result5[1] + "]");

    }

    // Time complexity: O(n2), where n is the length of the array.
    public static int[] pairSumUnsortedBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    // Time complexity: O(nlog(n)) because we sort the array in O(nlog(n)) time.
    // Space complexity: O(n) because we create a copy of the original array.
    private static int[] pairSumUnsortedSlightOptimization1(int[] nums, int target) {
        int[] original = Arrays.copyOf(nums, nums.length); // [-1, 3, 4, 2]
        Arrays.sort(nums); // [-1, 2, 3, 4]

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // Map back to original array indices
                int index1 = -1;
                int index2 = -1;
                for (int i = 0; i < original.length; i++) {
                    if (original[i] == nums[left] && index1 == -1) {
                        index1 = i;
                    } else if (original[i] == nums[right] && index2 == -1) {
                        index2 = i;
                    }
                }
                return new int[] {index1, index2};
            }
        }

        return new int[0];
    }

    // Time complexity: O(nlog(n)) because we sort the array in O(nlog(n)) time.
    // Space complexity: O(n) because we create a copy of the original array.
    private static int[] pairSumUnsortedSlightOptimization2(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];

        // Store values with original indices
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair.value));

        int left = 0;
        int right = pairs.length - 1;

        while (left < right) {
            int sum = pairs[left].value + pairs[right].value;
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] {pairs[left].index, pairs[right].index};
            }
        }
        return new int[0];
    }

    // Time complexity: O(n) because we iterate through the array once.
    // Space complexity: O(n) because we use a hash map to store the array values.
    public static int[] pairSumSortedOptimized1(int[] nums, int target) {
        // x + y = target
        // x = target - y (we can call this number the complement of x)
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[] {i, numMap.get(complement)};
            }
        }
        return new int[0];
    }

    // Time complexity: O(n) because we iterate though each element in the nums array once and perform constant-time
    // hash map operations during each iteration.
    // Space complexity: O(n) since the hash map can grow up to n in size
    public static int[] pairSumSortedOptimized2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
