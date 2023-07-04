package coding.arrays.easy;

import java.util.List;

/**
  EASY

  Given two non-empty arrays of integers, write a function that determines
  whether the second array is a subsequence of the first one.

  A subsequence of an array is a set of numbers that aren't necessarily adjacent
  in the array but that are in the same order as they appear in the array. For
  instance, the numbers [1, 3, 4] form a subsequence of the array
  [1, 2, 3, 4], and so do the numbers [2, 4]. Note
  that a single number in an array and the array itself are both valid
  subsequences of the array.

    Sample Input
    array = [5, 1, 22, 25, 6, -1, 8, 10]
    sequence = [1, 6, -1, 10]

    Sample Output
    true

 */
public class ValidateSubsequence {

    // O(n) time | O(1) space - where n is the length of the array
    public static boolean isValidSubsequence1(List<Integer> array, List<Integer> sequence) {
    /*
      [1,4,6,8,10] - array 1
      [4,8,10] - sequence
      Yes, valid subsequence
      1 - 1 == 4? i++
      4 - 4 == 4? j++, i++
      6 - 6 == 8? i++
      8 - 8 == 8? i++ j++
      10 - 10 == 10? j++
    size == j? true else false
  O(n) T | O(1) space
    */
        int seqIdx = 0;
        for (int value : array) {
            if (seqIdx == sequence.size()) {
                break;
            }
            if (value == sequence.get(seqIdx)) {
                seqIdx++;
            }
        }

        return seqIdx == sequence.size();
    }


    // O(n) time | O(1) space - where n is the length of array
    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
   /*
      [1,4,6,8,10] - array 1
      [4,6,8] - sequence
      Yes, valid subsequence
    */
        int arrIdx = 0;
        int seqIdx = 0;
        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                seqIdx++;
            }
            arrIdx++;
        }

        return seqIdx == sequence.size();
    }


}
