package coding.playground.patterns.twopointers;

// Given an array of integers sorted in ascending order and a target value, return the indexes of any pair
// of numbers in the array that sum to the target. The order of the indexes in the result doesn't matter.
// If no pair is found, return an empty array.
public class PairSumSorted {
    public static void main(String[] args) {
        int[] nums = new int[]{-5, -2, 3, 4, 6};
        int target = 7;
        // Output: [2, 3]
        // Explanation: nums[2] + nums[3] = 3 + 4 = 7
        int[] result = pairSumSortedBruteForce(nums, target);
        System.out.println("Result: pair [" + result[0] + ", " + result[1] + "]");

        int[] nums2 = new int[]{1, 1, 1};
        int target2 = 2;
        // Output: [0, 1]
        // Explanation: other valid outputs could be [1, 0], [0, 2], [2, 0], [1, 2], or [2, 1]
        int[] result2 = pairSumSortedBruteForce(nums2, target2);
        System.out.println("Result: pair [" + result2[0] + ", " + result2[1] + "]");

        int[] resultOpt = pairSumSortedOptimized(nums, target);
        System.out.println("Result: pair [" + resultOpt[0] + ", " + resultOpt[1] + "]");
        int[] resultOpt2 = pairSumSortedOptimized(nums2, target2);
        System.out.println("Result: pair [" + resultOpt2[0] + ", " + resultOpt2[1] + "]");


    }

    // Time complexity: O(n2), where n is the length of the array
    public static int[] pairSumSortedBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{};
    }

    // Time complexity: O(n) because we perform approximately n iterations using the two pointer technique in the worst case.
    // Space complexity: O(1) because we only allocated a constant number of variables.
    public static int[] pairSumSortedOptimized(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If the sum is smaller, increment the left pointer, aiming to increase the sum toward the target value.
            if (sum < target) {
                left++;
            }
            // If the sum is larger, decrement the right pointer, aiming to decrease the sum toward the target value.
            else if (sum > target) {
                right--;
            }
            // If the target pair is found, return its indexes
            else {
                return new int[] {left, right};
            }
        }
        return new int[]{};
    }
}
