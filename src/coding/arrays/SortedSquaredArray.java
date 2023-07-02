package coding.arrays;

import java.util.Arrays;

/**
 * EASY

  Write a function that takes in a non-empty array of integers that are sorted
  in ascending order and returns a new array of the same length with the squares
  of the original integers also sorted in ascending order.

    Sample Input
    array = [1, 2, 3, 5, 6, 8, 9]

    Sample Output
    [1, 4, 9, 25, 36, 64, 81]
 */
public class SortedSquaredArray {
    // O(nlogn) time | O(n) space - where n is the length of the input array
    public int[] sortedSquaredArray(int[] array) {
    /*
      [2,4,5,7,9] - input array
      [4,16,25,79,81] - result (squares)

      [-5,-2,3,5,6] - input
      [25,4,9,25,36] - squares
      [4,9,25,36,25] - result
      O(nlog(n)) time | O(n) space
    */
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] * array[i];
        }
        Arrays.sort(result);
        return result;
    }


    // O(n) time | O(1) space - where n is the length of the input array
    public int[] sortedSquaredArray2(int[] array) {
    /*
      [-5,-2,3,5,6] - input
      [25,4,9,25,36] - squares
      [4,9,25,36,25] - result

      -5 --- 6 | absolute value 5 < 6 -> no swap, r--
      |5| --- |5|, swap, r--
      |5| --- |3|, swap, r--
      |3| --- |2|, swap, r--
      while (l < r)
    */
    int leftIdx = 0;
    int rightIdx = array.length - 1;
    int[] result = new int[array.length];
    for (int idx = array.length - 1; idx >= 0; idx--) {
        if (Math.abs(array[leftIdx]) > Math.abs(array[rightIdx])) {
            result[idx] = array[leftIdx] * array[leftIdx];
            leftIdx++;
        } else {
            result[idx] = array[rightIdx] * array[rightIdx];
            rightIdx--;
        }
    }

    return result;
}

}
