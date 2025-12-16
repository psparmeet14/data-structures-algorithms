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

    public boolean hasTwoSameElements_hashSetAndForEach(int[] nums) {
//        HashSet<Integer> seen = new HashSet<>();
//        for (int num : nums) {
//            if (seen.contains(num)) {
//                return true;
//            }
//            seen.add(num);
//        }
//        return false;
    }
}
