package coding.arrays;

import java.util.HashSet;

public class Playground {

    /**
     * NOTE: Index-based loops are more appropriate here because we need control over comparison boundaries.
     *
     * Time Complexity: O(n^2), where n is the length of nums.
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public boolean hasTwoSameElements_forLoop(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println(nums[i] + " " + nums[j]);
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
         }
        return false;
    }

    /**
     * Using HashSet to track seen elements.
     *
     * Time Complexity: O(n), where n is the length of nums.
     * Space Complexity: O(n), where n is the number of unique elements in nums.
     *
     * @param nums
     * @return
     */
    public boolean hasTwoSameElements_hashSetAndForEach(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Using HashSet to track seen elements.
     *
     * Time Complexity: O(n), where n is the length of nums.
     * Space Complexity: O(n), where n is the number of unique elements in nums.
     *
     * @param nums
     * @return
     */
    public boolean hasTwoSameElements_hashSetAndForEach2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}
