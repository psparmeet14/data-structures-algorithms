package coding.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MEDIUM

 Three number sum

 Sample Input:
 array = [12, 3, 1, 2, -6, 5, -8, 6]
 targetSum = 0

 Sample Output:
 [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]

 */
public class ThreeNumberSum {
    // O(n^2) time | O(n) space - where n is the length of the input array
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    /*
        array = [12, 3, 1, 2, -6, 5, -8, 6]
        targetSum = 0

        output = [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]

        sort = [-8, -6, 1, 2, 3, 5, 6, 12]
        -8 - 6 + 12 = -2
        -8 + 1 + 12 = 5
        -8 + 1 + 6 = -1
        -8 + 2 + 6 = 0
        -8 + 3 + 5 = 0, next++, r--

        -6 + 1 + 12 = 7
        -6 + 1 + 6 = 1
        -6 + 1 + 5 = 0
    */
        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<Integer[]>();
        for (int i = 0; i < array.length - 2; i++) {
            int leftIdx = i + 1;
            int rightIdx = array.length - 1;
            while (leftIdx < rightIdx) {
                int currentSum = array[i] + array[leftIdx] + array[rightIdx];
                if (currentSum < targetSum) {
                    leftIdx++;
                } else if (currentSum > targetSum) {
                    rightIdx--;
                } else {
                    triplets.add(new Integer[] { array[i], array[leftIdx], array[rightIdx] });
                    leftIdx++;
                    rightIdx--;
                }
            }
        }

        return triplets;
    }
}
