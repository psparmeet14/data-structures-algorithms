package coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * EASY

 Write a function that takes in a non-empty array of distinct integers and an
 integer representing a target sum. If any two numbers in the input array sum
 up to the target sum, the function should return them in an array, in any
 order. If no two numbers sum up to the target sum, the function should return
 an empty array.


 Note that the target sum has to be obtained by summing two different integers
 in the array; you can't add a single integer to itself in order to obtain the
 target sum.


 You can assume that there will be at most one pair of numbers summing up to
 the target sum.

 Array  = [3, 5, -4, 8, 11, 1, -1, 6]
 targetSum = 10
 *
 * FIRST
 * # O(N^2) time, O(1) space
 * # run two for loops and compare every pair to see if it matches.
 *
 * SECOND
 * # O(N logN) time and O(1) space
 * # sort the array first and then use the two pointer approach to find the target sum.
 *
 * THIRD
 * # O(n) time and O(n) space
 * # solve for x + y = targetSum, calculate y, and see if its present in hashtable, if not store x in hastable.
 */
public class TwoNumberSum {
    // O(n^2) time | O(1) space
    public static int[] twoNumberSum1(int[] array, int targetSum) {
    /*
      [1,2,3,4] => 7
      traverse each ele once
      for each ele, another traversal from next ele till last
      1 + 2, 1 + 3, 1 + 4
      2 + 3, 2 + 4
      3 + 4
      4 == last ele, break leoop
    i + j, where j = i + 1
    i < length - 2
    j < length - 1
    O(n2) T, O(1) S
    */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[] {array[i], array[j]};
                }
            }
        }

        return new int[0];
    }

    // O(nlog(n)) time | O(1) space
    public static int[] twoNumberSum2(int[] array, int targetSum) {
    /*
      [1,-4,2,4,7,-2] => -1
      [-4,-2,1,2,4,7]
      -4 + 7 = 3 | 3 > -1 ? j--
      -4 + 4 = 0 > -1 ? j--
      -4 + 2 = -2 > -1 ? i++
      -2 + 2 = 0 > -1 ? j--
      -2 + 1 = -1 YES
      O(nlogn) T, O(1) S
    */
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == targetSum) {
                return new int[] {array[left], array[right]};
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    // O(n) time | O(n) space
    public static int[] twoNumberSum3(int[] array, int targetSum) {
    /*
      [1,-4,2,4,7,-2] => -1
      x + y = targetSum
      y = targetSum - x;
      List[x1,x2,x3,x4,...]
      x = 1, -1 - 1 = -2, list.contains(-2) ? x, y : x++
      x = -4, -1 + 4 = 3, list [1, -4] , x++
      x = 2, -1 - 2 = -3, list [1, -4, 2], x++
      x = 4, -1 - 4 = -5, list[1,-4,3,4], x++
      x = 7, -1 - 7 = -8, list[1,-4,3,4,7], x++
      x = -2, -1 + 2 = 1, list[1,-4,3,4,7]
      O(n) T, O(n) space
    */
        List<Integer> traversedNumbers = new ArrayList<>();
        for (int num : array) {
            int targetEle = targetSum - num;
            if (traversedNumbers.contains(targetEle)) {
                return new int[]{num, targetEle};
            }
            traversedNumbers.add(num);
        }
        return new int[0];
    }
}
